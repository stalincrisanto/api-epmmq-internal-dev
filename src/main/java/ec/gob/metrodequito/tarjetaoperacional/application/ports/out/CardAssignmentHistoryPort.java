package ec.gob.metrodequito.tarjetaoperacional.application.ports.out;

import ec.gob.metrodequito.tarjetaoperacional.domain.model.CardAssignmentHistory;

import java.util.Optional;

public interface CardAssignmentHistoryPort {
    CardAssignmentHistory save (CardAssignmentHistory cardAssignmentHistory);
    Optional<CardAssignmentHistory> findActiveByCardCode (String cardCode);
    Optional<CardAssignmentHistory> findActiveByDocumentNumber (String documentNumber);
}
