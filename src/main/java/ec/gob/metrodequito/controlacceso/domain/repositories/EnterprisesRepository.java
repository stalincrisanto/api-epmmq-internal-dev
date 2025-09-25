package ec.gob.metrodequito.controlacceso.domain.repositories;

import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Enterprises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterprisesRepository extends JpaRepository<Enterprises, Integer> {
}
