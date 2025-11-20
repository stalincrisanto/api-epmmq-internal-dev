package ec.gob.metrodequito.tarjetaoperacional.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOperationStaffDto {
    @NotEmpty(message = "El nombre es requerido")
    private String name;
    @NotEmpty(message = "El apellido es requerido")
    private String lastName;
    @NotEmpty(message = "El correo electrónico no puede estar vacío.")
    @Email(message = "El correo no tiene un formato válido")
    private String email;
    /*@NotEmpty(message = "El número de cédula no puede ser vacío")
    @Pattern(regexp = "^[0-9]{10}$", message = "El número de documento debe contener exactamente 10 dígitos numéricos.")
    private String documentNumber;*/
    @Pattern(regexp = "^\\d{10}$", message = "El número de teléfono debe tener 10 dígitos y solo contener números.")
    private String phoneNumber;
    @NotNull(message = "El ID del departamento no puede ser nulo.")
    private Long departmentId;
    @NotNull(message = "El ID del departamento no puede ser nulo.")
    private Long institutionalPositionId;
}
