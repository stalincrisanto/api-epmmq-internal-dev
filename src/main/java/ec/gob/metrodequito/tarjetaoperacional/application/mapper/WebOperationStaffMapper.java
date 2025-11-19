package ec.gob.metrodequito.tarjetaoperacional.application.mapper;

import ec.gob.metrodequito.tarjetaoperacional.application.dto.OperationStaffDto;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WebOperationStaffMapper {
    OperationStaff toDomain (OperationStaffDto dto);
    OperationStaffDto toDto (OperationStaff domain);
}
