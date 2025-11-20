package ec.gob.metrodequito.tarjetaoperacional.application.dto.request;

import ec.gob.metrodequito.tarjetaoperacional.application.dto.CreateCardAssignmentHistoryDto;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.CreateOperationStaffDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardAssignmentRequest {
    @NotEmpty(message = "El número de cédula no puede ser vacío ni nulo")
    @Pattern(regexp = "^[0-9]{10}$", message = "La cédula debe contener exactamente 10 dígitos numéricos.")
    private String documentNumber;
    @Valid
    private CreateOperationStaffDto staff;
    @Valid
    @NotNull(message = "Los datos de la tarjeta son requeridos")
    private CreateCardAssignmentHistoryDto assignment;
}
