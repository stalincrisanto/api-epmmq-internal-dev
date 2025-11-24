package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.mappers;

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
    CardAssignmentHistory toDomain(CardAssignmentHistoryEntity entity);

//    @Mapping(target = "activatedBy",
//            source = "activatedById",
//            qualifiedByName = "userFromId")
//    @Mapping(target = "operationsStaff",
//            source = "operationStaffId",
//            qualifiedByName = "operationStaffFromId")
    CardAssignmentHistoryEntity toEntity(CardAssignmentHistory domain);

//    @Named("userFromId")
//    default Users userFromId(String id) {
//        if (id == null) return null;
//        Users u = new Users();
//        u.setId(id);
//        return u;
//    }
//
//    @Named("operationStaffFromId")
//    default OperationStaffEntity operationStaffFromId(Long id) {
//        if (id == null) return null;
//        OperationStaffEntity os = new OperationStaffEntity();
//        os.setId(id);
//        return os;
//    }
}
