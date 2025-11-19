package ec.gob.metrodequito.tarjetaoperacional.application.dto.response;

import ec.gob.metrodequito.tarjetaoperacional.application.dto.OperationStaffDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardAssignmentResponse {
    private boolean isSuccessfully;
    private Long operationStaffId;
    private Long cardAssignationHistoryId;
}
