package ec.gob.metrodequito.tarjetaoperacional.application.services;

import ec.gob.metrodequito.tarjetaoperacional.application.mapper.WebSearchCardAssignmentMapper;
import ec.gob.metrodequito.tarjetaoperacional.application.ports.in.SearchCardAssignmentUseCase;
import ec.gob.metrodequito.tarjetaoperacional.application.ports.out.CardAssignmentHistoryPort;
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
    private final WebSearchCardAssignmentMapper mapper;

    @Override
    public Optional<SearchCardAssignmentResult> searchCardAssignment(SearchCriteria criteria) {
        Optional<CardAssignmentHistory> cardAssignment;
        if(criteria.getType() == SearchType.CARD_CODE){
            cardAssignment = cardAssignmentHistoryPort.findActiveByCardCode(criteria.getValue());
            System.out.println("EN EL SERVICIO----------" + cardAssignment.get().getOperationStaff().getDepartment().getName());
        } else {
            cardAssignment = cardAssignmentHistoryPort.findActiveByDocumentNumber(criteria.getValue());
        }
        return cardAssignment.map(mapper::toResult);
    }
}
