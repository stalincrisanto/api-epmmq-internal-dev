package ec.gob.metrodequito.tarjetaoperacional.infraestructure.controllers;

import ec.gob.metrodequito.common.application.ApiResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.SearchRequestDto;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.SearchCardAssignmentReponse;
import ec.gob.metrodequito.tarjetaoperacional.application.mapper.WebSearchCardAssignmentMapper;
import ec.gob.metrodequito.tarjetaoperacional.application.ports.in.SearchCardAssignmentUseCase;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.SearchCriteria;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/assignment-card")
public class SearchCardAssignmentController {

    private SearchCardAssignmentUseCase searchCardAssignmentUseCase;
    private WebSearchCardAssignmentMapper mapper;

    @PostMapping("/search-active")
    public ResponseEntity<ApiResponse<SearchCardAssignmentReponse>> searchActiveAssignmentHistory(
            @Valid @RequestBody SearchRequestDto request) {

        try {
            SearchCriteria criteria = SearchCriteria.builder()
                    .type(request.getType())
                    .value(request.getValue())
                    .build();

            Optional<SearchCardAssignmentReponse> result = searchCardAssignmentUseCase.searchCardAssignment(criteria).map(mapper::toResponse);

            return result.map(searchCardAssignmentReponse -> ResponseEntity.ok(ApiResponse.success(searchCardAssignmentReponse, "Encontrado exitosamente"))).orElseGet(() -> ResponseEntity.ok(ApiResponse.success(null, "No se ha encontrado")));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
