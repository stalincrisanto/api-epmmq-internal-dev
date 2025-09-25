package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.domain.services.dto.UsersDto;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Users;

import java.util.Optional;

public interface  UserService {
    Optional<UsersDto> getOne(String Id);
    Optional<Users> getById(String Id);
    Optional<Users> getByUsername(String username);
    Users save(Users user);
    void delete(Users user);
}
