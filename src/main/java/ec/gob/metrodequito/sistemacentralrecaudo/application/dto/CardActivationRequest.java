package ec.gob.metrodequito.sistemacentralrecaudo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardActivationRequest {
    private String codActivation;
    private String name;
    private String lastName;
    private String documentId;
    private String expirationDate;
}
