package ec.gob.metrodequito.tarjetaoperacional.application.dto;

import lombok.Data;

@Data
public class OperationStaffDto {
    private Long id;
    private String name;
    private String lastName;
    private String documentNumber;
    private String email;
    private String phoneNumber;
}
