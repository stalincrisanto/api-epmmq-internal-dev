package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.repository;

import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.CardAssignmentHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardAssignmentHistoryRepository extends JpaRepository<CardAssignmentHistoryEntity, Long> {
}
