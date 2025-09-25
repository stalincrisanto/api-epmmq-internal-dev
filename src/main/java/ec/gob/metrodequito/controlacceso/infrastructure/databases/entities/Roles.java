package ec.gob.metrodequito.controlacceso.infrastructure.databases.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ac_roles")
public class Roles {
    @Id
    private BigInteger id;
    private String name;
    private Boolean isActive;
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<MenuRol> menusByRole;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private List<UserRol> usersByRol;
}