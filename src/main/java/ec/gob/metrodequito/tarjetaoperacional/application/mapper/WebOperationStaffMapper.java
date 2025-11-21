package ec.gob.metrodequito.tarjetaoperacional.application.mapper;

import ec.gob.metrodequito.tarjetaoperacional.application.dto.CreateOperationStaffDto;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.OperationStaffDto;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WebOperationStaffMapper {
    OperationStaff toDomain(CreateOperationStaffDto dto);
    OperationStaffDto toDto(OperationStaff domain);
}
