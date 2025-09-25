package ec.gob.metrodequito.controlacceso.infrastructure.databases.entities;

import jakarta.persistence.Column;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class UserRolPk {
    @Column(name = "user_id")
    private String userId;
    @Column(name = "rol_id")
    private BigInteger rolId;
}
