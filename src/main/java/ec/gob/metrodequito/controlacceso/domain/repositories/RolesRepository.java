package ec.gob.metrodequito.controlacceso.domain.repositories;

import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
