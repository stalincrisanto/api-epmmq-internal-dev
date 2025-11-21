package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities;

import ec.gob.metrodequito.common.infraestructure.database.entities.AuditableEntity;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Departments;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.InstitucionalPosition;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity()
@Table(name = "oc_operations_staff")
@Getter
@Setter
public class OperationStaffEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, length = 255)
    private String email;
    @Column(name = "document_number", nullable = false, length = 10)
    private String documentNumber;
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deparment_id")
    private Departments department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institutional_position_id")
    private InstitucionalPosition institutionalPosition;

    @OneToMany(mappedBy = "operationsStaff", cascade = CascadeType.PERSIST)
    private List<CardAssignmentHistoryEntity> cardAssignmentHistory;
}
