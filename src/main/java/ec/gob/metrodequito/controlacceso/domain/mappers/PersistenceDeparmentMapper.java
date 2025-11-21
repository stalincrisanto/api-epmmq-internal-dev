package ec.gob.metrodequito.controlacceso.domain.mappers;

import ec.gob.metrodequito.controlacceso.domain.models.Department;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Departments;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.InstitucionalPosition;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.OperationStaffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PersistenceDeparmentMapper {
    Department toDomain(Departments entity);
    Departments toEntity(Department domain);
}

