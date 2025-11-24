package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.repository;

import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.CardAssignmentHistoryEntity;
import ec.gob.metrodequito.tarjetaoperacional.utils.CardAssignmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CardAssignmentHistoryRepository extends JpaRepository<CardAssignmentHistoryEntity, Long> {
    @Query("""
            SELECT h FROM CardAssignmentHistoryEntity h 
            LEFT JOIN FETCH h.operationsStaff s
            LEFT JOIN FETCH s.department d
            LEFT JOIN FETCH s.institutionalPosition ip 
            WHERE h.cardCode = :cardCode AND h.status = :status
            """)
    Optional<CardAssignmentHistoryEntity> findByCardCodeAndStatus(
            @Param("cardCode") String cardCode,
            @Param("status") CardAssignmentStatus status);
    @Query("""
        SELECT h FROM CardAssignmentHistoryEntity h 
        LEFT JOIN FETCH h.operationsStaff s
        LEFT JOIN FETCH s.department d
        LEFT JOIN FETCH s.institutionalPosition ip 
        WHERE s.documentNumber = :documentNumber AND h.status = :status
    """)
    Optional<CardAssignmentHistoryEntity> findByOperationStaffDocumentNumberAndStatus(
            @Param("documentNumber") String documentNumber,
            @Param("status") CardAssignmentStatus status);
}
