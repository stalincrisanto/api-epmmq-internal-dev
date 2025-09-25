package ec.gob.metrodequito.controlacceso.domain.repositories;

import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.InstitucionalPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitucionalPositionRepository extends JpaRepository<InstitucionalPosition, Integer> {
}
