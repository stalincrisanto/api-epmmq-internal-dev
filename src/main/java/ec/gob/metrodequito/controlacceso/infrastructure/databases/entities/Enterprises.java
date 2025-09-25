package ec.gob.metrodequito.controlacceso.infrastructure.databases.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ac_enterprises")
public class Enterprises {
    @Id
    private BigInteger id;
    @Column(length = 60)
    private String name;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(length = 30)
    private String phone;
    @Column(length = 80)
    private String contact;

    @OneToMany(mappedBy = "enterprise")
    List<People> people;
}
