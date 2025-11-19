package ec.gob.metrodequito.tarjetaoperacional.application.ports.out;

import ec.gob.metrodequito.tarjetaoperacional.domain.model.CardAssignmentHistory;

public interface CardAssignmentHistoryPort {
    CardAssignmentHistory save (CardAssignmentHistory cardAssignmentHistory);
}
