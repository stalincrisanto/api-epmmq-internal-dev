package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities;

import ec.gob.metrodequito.common.infraestructure.database.entities.AuditableEntity;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Users;
import ec.gob.metrodequito.tarjetaoperacional.utils.CardAssignmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "oc_card_assignment_history")
@Getter
@Setter
public class CardAssignmentHistoryEntity extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_code", nullable = false)
    private String cardCode;
    @Column
    private String observation;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private CardAssignmentStatus status;
    @Column(name = "activation_date")
    private LocalDateTime activationDate;
    @Column(name = "deactivation_date")
    private LocalDateTime deactivationDate;
    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activated_by_id")
    private Users activatedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_staff_id")
    private OperationStaffEntity operationsStaff;
}
