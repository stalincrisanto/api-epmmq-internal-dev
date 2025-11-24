package ec.gob.metrodequito.tarjetaoperacional.application.mapper;

import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.CardAssignmentResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.SearchCardAssignmentReponse;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.CardAssignmentHistory;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.SearchCardAssignmentResult;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WebSearchCardAssignmentMapper {
    @Mapping(target = "operationStaffName", source = "operationStaff.name")
    @Mapping(target = "operationStaffLastName", source = "operationStaff.lastName")
    @Mapping(target = "operationStaffDocumentNumber", source = "operationStaff.documentNumber")
    @Mapping(target = "operationStaffEmail", source = "operationStaff.email")
    @Mapping(target = "departmentName", source = "operationStaff.department.name")
    @Mapping(target = "institutionalPositionName", source = "operationStaff.institutionalPosition.name")
    SearchCardAssignmentResult toResult(CardAssignmentHistory domain);
    @Mapping(target = "operationStaffName", source = "operationStaffName")
    @Mapping(target = "operationStaffLastName", source = "operationStaffLastName")
    @Mapping(target = "operationStaffDocumentNumber", source = "operationStaffDocumentNumber")
    @Mapping(target = "operationStaffEmail", source = "operationStaffEmail")
    @Mapping(target = "departmentName", source = "departmentName")
    @Mapping(target = "institutionalPositionName", source = "institutionalPositionName")
    SearchCardAssignmentReponse toResponse(SearchCardAssignmentResult result);
}
