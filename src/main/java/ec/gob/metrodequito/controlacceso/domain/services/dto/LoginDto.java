package ec.gob.metrodequito.controlacceso.domain.services.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String username;
    private String password;
}