package ec.gob.metrodequito.sistemacentralrecaudo.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountAbtVerifier {
    private boolean success;
    private String fullName;
    private String documentId;
    private String email;

    public boolean isValidPerson() {
        return !"9999999999999".equals(documentId)
                && !"CONSUMIDOR FINAL".equalsIgnoreCase(fullName);
    }
}
