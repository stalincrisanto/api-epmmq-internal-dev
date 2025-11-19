package ec.gob.metrodequito.tarjetaoperacional.application.ports.out;

import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;

import java.util.Optional;

public interface OperationStaffPort {
    Optional<OperationStaff> findByDocumentNumber (String documentNumber);
    Optional<OperationStaff> findById (Long id);
    OperationStaff save (OperationStaff operationStaff);
}
