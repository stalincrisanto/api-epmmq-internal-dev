package ec.gob.metrodequito.tarjetaoperacional.application.services;

import ec.gob.metrodequito.sistemacentralrecaudo.application.dto.AccountAbtVerifier;
import ec.gob.metrodequito.sistemacentralrecaudo.application.ports.out.AccountAbtVerifierPort;
import ec.gob.metrodequito.tarjetaoperacional.application.mapper.WebSearchCardAssignmentMapper;
import ec.gob.metrodequito.tarjetaoperacional.application.ports.in.SearchCardAssignmentUseCase;
import ec.gob.metrodequito.tarjetaoperacional.application.ports.out.CardAssignmentHistoryPort;
import ec.gob.metrodequito.tarjetaoperacional.domain.exceptions.CardNotAssignedException;
import ec.gob.metrodequito.tarjetaoperacional.domain.exceptions.DataDiscrepancyException;
import ec.gob.metrodequito.tarjetaoperacional.domain.exceptions.DataInconsistencyException;
import ec.gob.metrodequito.tarjetaoperacional.domain.exceptions.ExternalApiException;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.CardAssignmentHistory;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.SearchCardAssignmentResult;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.SearchCriteria;
import ec.gob.metrodequito.tarjetaoperacional.utils.SearchType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class SearchCardAssignmentService implements SearchCardAssignmentUseCase {
    private final CardAssignmentHistoryPort cardAssignmentHistoryPort;
    private final AccountAbtVerifierPort accountAbtVerifierPort;
    private final WebSearchCardAssignmentMapper mapper;

    @Override
    public Optional<SearchCardAssignmentResult> searchCardAssignment(SearchCriteria criteria) {
        AccountAbtVerifier abt = accountAbtVerifierPort.accountAbtVerifier(criteria.getType(), criteria.getValue());

        Optional<CardAssignmentHistory> cardAssignment =
                (criteria.getType() == SearchType.cardCode)
                        ? cardAssignmentHistoryPort.findActiveByCardCode(criteria.getValue())
                        : cardAssignmentHistoryPort.findActiveByDocumentNumber(criteria.getValue());

        boolean isFinalConsumer =
                "9999999999999".equals(abt.getDocumentId()) &&
                        "CONSUMIDOR FINAL".equalsIgnoreCase(abt.getFullName());

        if (criteria.getType() == SearchType.cardCode) {
            if (cardAssignment.isEmpty()) {
                if (isFinalConsumer) {
                    throw new CardNotAssignedException("La tarjeta " + criteria.getValue() + " no ha sido asignada");
                } else {
                    throw new CardNotAssignedException("La tarjeta " + criteria.getValue() + " no se encuentra en el sistema");
                }
            } else if (isFinalConsumer) {
                throw new DataDiscrepancyException("Existen discrepancias de datos para la tarjeta " + criteria.getValue());
            }
        } else if (criteria.getType() == SearchType.documentId) {
            if (cardAssignment.isEmpty()) {
                if (abt.getFullName() != null) {
                    throw new DataInconsistencyException("Inconsistencia de datos para la cédula: " + criteria.getValue());
                } else {
                    throw new CardNotAssignedException("La cédula " + criteria.getValue() + " no se encuentra asociada a una tarjeta");
                }
            }
        }
        return cardAssignment.map(mapper::toResult);
    }
}
