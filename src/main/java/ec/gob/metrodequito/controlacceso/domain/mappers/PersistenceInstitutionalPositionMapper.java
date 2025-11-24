package ec.gob.metrodequito.controlacceso.domain.mappers;

import ec.gob.metrodequito.controlacceso.domain.models.Department;
import ec.gob.metrodequito.controlacceso.domain.models.InstitutionalPosition;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Departments;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.InstitucionalPosition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersistenceInstitutionalPositionMapper {
    InstitutionalPosition toDomain(InstitucionalPosition entity);
    InstitucionalPosition toEntity(InstitucionalPosition domain);
}

