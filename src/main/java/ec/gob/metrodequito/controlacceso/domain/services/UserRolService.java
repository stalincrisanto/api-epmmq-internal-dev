package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.UserRol;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserRolService {
    UserRol save(UserRol userRol);
    void delete(UserRol userRol);
    Optional<List<UserRol>> findByUserId(String userId);
}