package ec.gob.metrodequito.controlacceso.infrastructure.databases.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ac_users")
public class Users {
    @Id
    private String id;
    private String username;
    @Column(name="password_hash")
    private String passwordHash;
    @Column(name="is_active")
    private Boolean isActive;
    @Column(name="is_looked")
    private Boolean isLooked;
    @Column(name="last_login_at")
    private LocalDateTime lastLoginAt;
    @Column(name="failed_login_attemps")
    private Integer failedLoginAttemps;
    @Column(name="password_updated_at")
    private LocalDateTime passwordUpdatedAt;

    @OneToMany(mappedBy = "user")
    //@JsonIgnore
    private List<UserRol>  roles;

    public Users(String id, String username, Boolean isActive, Boolean isLooked,
                 LocalDateTime lastLoginAt, Integer failedLoginAttemps, LocalDateTime passwordUpdatedAt) {
        this.id = id;
        this.username = username;
        this.isActive = isActive;
        this.isLooked = isLooked;
        this.lastLoginAt = lastLoginAt;
        this.failedLoginAttemps = failedLoginAttemps;
        this.passwordUpdatedAt = passwordUpdatedAt;
    }
}
