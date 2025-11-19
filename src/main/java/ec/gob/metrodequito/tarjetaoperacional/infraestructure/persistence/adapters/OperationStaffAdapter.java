package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.adapters;

import ec.gob.metrodequito.tarjetaoperacional.application.ports.out.OperationStaffPort;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.mappers.PersistenceOperationStaffMapper;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.repository.OperationStaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class OperationStaffAdapter implements OperationStaffPort {
    private final OperationStaffRepository repositoryOperationStaff;
    private final PersistenceOperationStaffMapper mapper;

    @Override
    public Optional<OperationStaff> findByDocumentNumber(String documentNumber) {
        return repositoryOperationStaff.findByDocumentNumber(documentNumber).map(this.mapper::toDomain);
    }
}
