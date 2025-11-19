package ec.gob.metrodequito.tarjetaoperacional.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardAssignmentHistoryDto {
    @NotEmpty(message = "El código de la tarjeta no puede ser vacío")
    @Pattern(regexp = "^[0-9]{10}$", message = "El código de la tarjeta debe contener exactamente 10 dígitos numéricos.")
    private String cardCode;
    @NotEmpty(message = "El motivo de asignación no puede ser vacío")
    private String reason;
    @NotNull(message = "La fecha de expiración no puede ser nula")
    @Future(message = "La fecha de expiración debe ser una fecha futura")
    private LocalDateTime expirationDate;
    @NotNull(message = "El id del usuario que activa la tarjeta no puede ser nula")
    private Long activatedById;
    @NotNull(message = "El id del usuario asignado a la tarjeta no puede ser nula")
    private Long operationStaffId;
}
