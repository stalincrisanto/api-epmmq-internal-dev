package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.repository;

import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.OperationStaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationStaffRepository extends JpaRepository<OperationStaffEntity, Long> {
    Optional<OperationStaffEntity> findByDocumentNumber(String documentNumber);
}
