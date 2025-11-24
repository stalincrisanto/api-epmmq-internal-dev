package ec.gob.metrodequito.tarjetaoperacional.application.mapper;

import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.SearchCardAssignmentReponse;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.SearchCardAssignmentResult;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WebSearchCardAssignmentMapper {
    SearchCardAssignmentReponse toResponse (SearchCardAssignmentResult domain);
}
