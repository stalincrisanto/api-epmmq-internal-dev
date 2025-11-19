package ec.gob.metrodequito.tarjetaoperacional.application.dto.request;

import ec.gob.metrodequito.tarjetaoperacional.application.dto.CreateCardAssignmentHistoryDto;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.CreateOperationStaffDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardAssignmentRequest {
    @NotEmpty(message = "El número de cédula no puede ser vacío ni nulo")
    @Pattern(regexp = "^[0-9]{10}$", message = "La cédula debe contener exactamente 10 dígitos numéricos.")
    private String documentNumber;
    @Valid
    private CreateOperationStaffDto operationStaffDto;
    @Valid
    @NotNull(message = "Los datos de la tarjeta son requeridos")
    private CreateCardAssignmentHistoryDto cardAssignmentHistoryDto;
}
