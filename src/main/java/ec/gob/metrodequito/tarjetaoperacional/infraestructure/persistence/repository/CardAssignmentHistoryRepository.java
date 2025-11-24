package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.repository;

import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.CardAssignmentHistoryEntity;
import ec.gob.metrodequito.tarjetaoperacional.utils.CardAssignmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CardAssignmentHistoryRepository extends JpaRepository<CardAssignmentHistoryEntity, Long> {
    Optional<CardAssignmentHistoryEntity> findByCardCodeAndStatus(String cardCode, CardAssignmentStatus status);
    @Query("SELECT h FROM CardAssignmentHistoryEntity h JOIN h.operationsStaff s WHERE s.documentNumber = :documentNumber AND h.status = :status")
    Optional<CardAssignmentHistoryEntity> findByOperationStaffDocumentNumberAndStatus(
            @Param("documentNumber") String documentNumber,
            @Param("status") CardAssignmentStatus status);
}
