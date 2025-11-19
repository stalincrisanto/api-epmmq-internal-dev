package ec.gob.metrodequito.tarjetaoperacional.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OperationStaff {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String documentNumber;
    private String phoneNumber;
    private Long departmentId;
    private Long institutionalPositionId;
    private LocalDateTime createdAt;
    private Boolean isActive;
    private LocalDateTime updatedAt;
}
