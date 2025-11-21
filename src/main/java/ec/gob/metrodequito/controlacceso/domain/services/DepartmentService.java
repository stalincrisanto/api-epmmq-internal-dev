package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.domain.models.Department;

import java.util.Optional;

public interface DepartmentService {
    Optional<Department> getById(Integer Id);
}
