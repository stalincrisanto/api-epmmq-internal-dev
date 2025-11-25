package ec.gob.metrodequito.sistemacentralrecaudo.application.ports.out;

import ec.gob.metrodequito.sistemacentralrecaudo.application.dto.AccountAbtVerifier;
import ec.gob.metrodequito.tarjetaoperacional.utils.SearchType;

public interface AccountAbtVerifierPort {
    AccountAbtVerifier accountAbtVerifier (SearchType type, String value);
}
