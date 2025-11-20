package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.mappers;

import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Departments;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.InstitucionalPosition;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.OperationStaffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PersistenceOperationStaffMapper {

    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "institucionalPosition.id", target = "institutionalPositionId")
    OperationStaff toDomain(OperationStaffEntity entity);

    @Mapping(target = "department",
            source = "departmentId",
            qualifiedByName = "departmentFromId")
    @Mapping(target = "institucionalPosition",
            source = "institutionalPositionId",
            qualifiedByName = "positionFromId")
    OperationStaffEntity toEntity(OperationStaff domain);

    @Named("departmentFromId")
    default Departments departmentFromId(Integer id) {
        if (id == null) return null;
        Departments d = new Departments();
        d.setId(id);
        return d;
    }

    @Named("positionFromId")
    default InstitucionalPosition positionFromId(Integer id) {
        if (id == null) return null;
        InstitucionalPosition p = new InstitucionalPosition();
        p.setId(id);
        return p;
    }
}

