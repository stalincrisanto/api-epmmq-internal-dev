package ec.gob.metrodequito.tarjetaoperacional.domain.model;

import ec.gob.metrodequito.controlacceso.domain.models.Department;
import ec.gob.metrodequito.controlacceso.domain.models.InstitutionalPosition;
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
    private Department department;
    private InstitutionalPosition institutionalPosition;
}
