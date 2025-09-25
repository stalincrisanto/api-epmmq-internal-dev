package ec.gob.metrodequito.controlacceso.domain.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class MenusCortoDto {
    @JsonIgnore
    private Integer id;
    private String title;
    private String path;
    @JsonIgnore
    private Integer parentId;
    private List<MenusCortoDto> subNav;
}