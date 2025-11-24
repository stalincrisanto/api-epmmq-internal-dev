package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.mappers;

import ec.gob.metrodequito.controlacceso.domain.models.Department;
import ec.gob.metrodequito.controlacceso.domain.models.InstitutionalPosition;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Departments;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.InstitucionalPosition;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Users;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.CardAssignmentHistory;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.CardAssignmentHistoryEntity;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.OperationStaffEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PersistenceCardAssignmentHistoryMapper {

    @Mapping(
            target = "operationStaff",
            expression = "java(mapOperationStaffToDomain(entity.getOperationsStaff()))"
    )
    CardAssignmentHistory toDomain(CardAssignmentHistoryEntity entity);

    Department toDomain(Departments entity);

    InstitutionalPosition toDomain(InstitucionalPosition entity);

    default OperationStaff mapOperationStaffToDomain(OperationStaffEntity entity) {
        if (entity == null) return null;

        OperationStaff domain = new OperationStaff();
        domain.setId(entity.getId());
        domain.setName(entity.getName());
        domain.setLastName(entity.getLastName());
        domain.setEmail(entity.getEmail());
        domain.setDocumentNumber(entity.getDocumentNumber());
        domain.setPhoneNumber(entity.getPhoneNumber());

        if (entity.getDepartment() != null) {
            domain.setDepartment(toDomain(entity.getDepartment()));
        }

        if (entity.getInstitutionalPosition() != null) {
            domain.setInstitutionalPosition(toDomain(entity.getInstitutionalPosition()));
        }

        return domain;
    }

    CardAssignmentHistoryEntity toEntity(CardAssignmentHistory domain);
}
