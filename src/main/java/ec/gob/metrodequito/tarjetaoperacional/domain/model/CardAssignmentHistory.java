package ec.gob.metrodequito.tarjetaoperacional.domain.model;

import ec.gob.metrodequito.tarjetaoperacional.utils.CardAssignmentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CardAssignmentHistory {
    private Long id;
    private String cardCode;
    private String observation;
    private CardAssignmentStatus status;
    private LocalDateTime activationDate;
    private LocalDateTime deactivationDate;
    private LocalDateTime expirationDate;
    private Long activatedById;
    private Long operationStaffId;
    private LocalDateTime createdAt;
    private Boolean isActive;
    private LocalDateTime updatedAt;
}
