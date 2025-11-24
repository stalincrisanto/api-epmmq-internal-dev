package ec.gob.metrodequito.tarjetaoperacional.domain.model;

import ec.gob.metrodequito.tarjetaoperacional.utils.CardAssignmentStatus;

import java.time.LocalDateTime;

public class SearchCardAssignmentResult {
    private String cardCode;
    private String reason;
    private CardAssignmentStatus status;
    private LocalDateTime activationDate;
    private LocalDateTime deactivationDate;
    private LocalDateTime expirationDate;
    private String operationStaffName;
    private String operationStaffLastName;
    private String operationStaffDocumentNumber;
    private String operationStaffEmail;
}
