package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Roles;

import java.util.List;
import java.util.Optional;

public interface RolesService {
    List<Roles> getAll();
    Optional<Roles> getRoleById(Integer id);
    Roles save(Roles role);
    void delete(Roles role);
}
