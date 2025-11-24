package ec.gob.metrodequito.tarjetaoperacional.application.dto;

import ec.gob.metrodequito.tarjetaoperacional.utils.SearchType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchRequestDto {
    private SearchType type;
    private String value;
}

