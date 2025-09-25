package ec.gob.metrodequito.controlacceso.infrastructure.databases.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "ac_user_rol")
@IdClass(value = UserRolPk.class)
public class UserRol {
    @Id
    @Column(name = "user_id")
    @JsonIgnore
    private String userId;
    @Id
    @Column(name = "rol_id")
    private BigInteger rolId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "rol_id", insertable = false, updatable = false)
    private Roles role;
}
