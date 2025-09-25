package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.domain.repositories.UserRolRepository;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.UserRol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRolServiceImpl implements  UserRolService {
    private final UserRolRepository repository;
    @Override
    public UserRol save(UserRol userRol) {
        return repository.save(userRol);
    }

    @Override
    public void delete(UserRol userRol) {
        repository.delete(userRol);
    }

    @Override
    public Optional<List<UserRol>> findByUserId(String userId) {
        return repository.findAllByUserId(userId);
    }
}
