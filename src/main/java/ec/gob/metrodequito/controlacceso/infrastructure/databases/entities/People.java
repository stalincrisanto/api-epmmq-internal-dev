package ec.gob.metrodequito.controlacceso.infrastructure.databases.entities;

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
@Table(name = "ac_users")
public class People {
    @Id
    private String id;
    @Column(name = "enterprise_id")
    private Integer enterpriseId;
    @Column(name = "department_id")
    private Integer departmentId;
    @Column(name = "position_id")
    private Integer positionId;
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    @Column(name="password_hash")
    private String passwordHash;
    @Column(name="user_type")
    private String userType;
    @Column(name="is_active")
    private Boolean isActive;
    @Column(name="is_looked")
    private Boolean isLooked;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="updated_by")
    private String updatedBy;
    @Column(name="failed_login_attemps")
    private Integer failedLoginAttemps;
    @Column(name="password_updated_at")
    private LocalDateTime passwordUpdatedAt;

    @ManyToOne
    @JoinColumn(name = "department_id", insertable = false, updatable = false)
    private Departments department;

    @ManyToOne
    @JoinColumn(name = "position_id", insertable = false, updatable = false)
    private InstitucionalPosition position;

    @ManyToOne
    @JoinColumn(name = "enterprise_id", insertable = false, updatable = false)
    private Enterprises enterprise;

}
