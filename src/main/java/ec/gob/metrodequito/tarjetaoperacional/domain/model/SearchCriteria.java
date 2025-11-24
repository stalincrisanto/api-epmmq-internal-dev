package ec.gob.metrodequito.tarjetaoperacional.domain.model;

import ec.gob.metrodequito.tarjetaoperacional.utils.SearchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SearchCriteria {
    private SearchType type;
    private String value;
}