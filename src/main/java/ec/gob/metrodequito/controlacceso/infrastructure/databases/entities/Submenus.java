package ec.gob.metrodequito.controlacceso.infrastructure.databases.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ac_menus")
public class Submenus {
    @Id
    private Integer id;
    private String name;
    private String path;
    @Column(name = "parent_id")
    private String parentId;
    private String icon;
    @Column(name = "is_active")
    private Boolean isActive;
    @JsonIgnore
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @JsonIgnore
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @JsonIgnore
    @Column(name = "created_by")
    private String createdBy;
    @JsonIgnore
    @Column(name = "updated_by")
    private String updatedBy;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "parent_id", insertable = false, updatable = false)
    private Menus menus;
}
