package ec.gob.metrodequito.controlacceso.infrastructure.databases.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class MenuRolPk {
    @Column(name = "menu_id")
    private Integer menuId;
    @Column(name = "role_id")
    private Integer roleId;
}
