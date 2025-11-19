package ec.gob.metrodequito.tarjetaoperacional.application.ports.in;

import ec.gob.metrodequito.tarjetaoperacional.application.dto.request.CardAssignmentRequest;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.CardAssignmentResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.OperationStaffResponse;

public interface CardAssignmentUseCase {
    OperationStaffResponse verifiedOperationStaffExists(String documentNumber);
    CardAssignmentResponse assignCardProcess (CardAssignmentRequest request);
}
