package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.mappers;

import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.OperationStaffEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersistenceOperationStaffMapper {
    OperationStaff toDomain(OperationStaffEntity entity);
    OperationStaffEntity toEntity(OperationStaff domain);
}
