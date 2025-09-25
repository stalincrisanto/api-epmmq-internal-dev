package ec.gob.metrodequito.controlacceso.infrastructure.databases.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "ac_menurol")
@Entity
@IdClass(value = MenuRolPk.class)
public class MenuRol {
    @Id
    @Column(name = "menu_id")
    private Integer menuId;
    @Id
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name="sort_order")
    private Integer sortOrder;



    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "menu_id", insertable = false, updatable = false)
    private Menus menus;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Roles role;
}
