package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.repository;

import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.OperationStaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationStaffRepository extends JpaRepository<OperationStaffEntity, Long> {
    @Query("""
           SELECT os FROM OperationStaffEntity os
           JOIN FETCH os.department
           JOIN FETCH os.institutionalPosition
           WHERE os.documentNumber = :documentNumber
           """)
    Optional<OperationStaffEntity> findByDocumentNumber(@Param("documentNumber") String documentNumber);
}
