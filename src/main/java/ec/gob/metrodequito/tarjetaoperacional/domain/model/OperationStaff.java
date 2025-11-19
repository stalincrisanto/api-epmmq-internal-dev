package ec.gob.metrodequito.tarjetaoperacional.domain.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperationStaff {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String documentNumber;
    private String phoneNumber;
    private Long departmentId;
    private Long institutionalPositionId;
}
