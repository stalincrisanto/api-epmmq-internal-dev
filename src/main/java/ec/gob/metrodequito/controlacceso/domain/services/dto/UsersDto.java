package ec.gob.metrodequito.controlacceso.domain.services.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class UsersDto {
    private String id;
    private String username;
    private Boolean isActive;
    private Boolean isLooked;
    private LocalDateTime lastLoginAt;
    private Integer failedLoginAttemps;
    private LocalDateTime passwordUpdatedAt;
}
