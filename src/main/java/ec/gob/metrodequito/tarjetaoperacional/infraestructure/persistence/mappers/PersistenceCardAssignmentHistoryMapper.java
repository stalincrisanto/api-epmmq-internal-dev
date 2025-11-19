package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.mappers;

import ec.gob.metrodequito.tarjetaoperacional.domain.model.CardAssignmentHistory;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.CardAssignmentHistoryEntity;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.OperationStaffEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersistenceCardAssignmentHistoryMapper {
    CardAssignmentHistory toDomain(CardAssignmentHistoryEntity entity);
    CardAssignmentHistoryEntity toEntity(CardAssignmentHistory domain);
}
