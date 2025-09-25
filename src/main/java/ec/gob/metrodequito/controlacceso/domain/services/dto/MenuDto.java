package ec.gob.metrodequito.controlacceso.domain.services.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuDto {
    private Integer id;
    private String name;
    private String path;
    private Integer parentId;
    private String icon;
    private Boolean isActive;
    private List<MenuDto> submenus;
}