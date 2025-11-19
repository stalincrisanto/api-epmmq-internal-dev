package ec.gob.metrodequito.controlacceso.infrastructure.databases.entities;

import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.OperationStaffEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ac_departments")
public class Departments {
    @Id
    private Integer id;
    private String name;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="updated_by")
    private String updatedBy;

    @OneToMany(mappedBy = "department")
    private List<People> people;

    @OneToMany(mappedBy = "department")
    private List<OperationStaffEntity> operationsStaff;
}
