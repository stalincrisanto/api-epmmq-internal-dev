package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.domain.models.Department;
import ec.gob.metrodequito.controlacceso.domain.models.InstitutionalPosition;

import java.util.Optional;

public interface InstitutionalPositionService {
    Optional<InstitutionalPosition> getById(Integer Id);
}
