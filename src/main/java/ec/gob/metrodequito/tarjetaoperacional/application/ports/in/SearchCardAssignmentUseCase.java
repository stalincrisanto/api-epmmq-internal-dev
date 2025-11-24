package ec.gob.metrodequito.tarjetaoperacional.application.ports.in;

import ec.gob.metrodequito.tarjetaoperacional.domain.model.SearchCardAssignmentResult;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.SearchCriteria;

import java.util.Optional;

public interface SearchCardAssignmentUseCase {
    Optional<SearchCardAssignmentResult> searchCardAssignment (SearchCriteria criteria);
}
