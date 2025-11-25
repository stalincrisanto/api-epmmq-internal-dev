package ec.gob.metrodequito.sistemacentralrecaudo.application.ports.out;

import ec.gob.metrodequito.sistemacentralrecaudo.application.dto.CardActivationRequest;

public interface CardActivationPort {
    void activateCard(CardActivationRequest request);
}
