package ec.gob.metrodequito.controlacceso.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InstitutionalPosition {
    private Integer id;
    private String name;
    private String code;
}
