package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Roles;
import ec.gob.metrodequito.controlacceso.domain.repositories.RolesRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RolesServiceImpl implements  RolesService{
    private final RolesRepository repository;
    @Override
    public List<Roles> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Roles> getRoleById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Roles save(Roles role) {
        return repository.save(role);
    }

    @Override
    public void delete(Roles role) {
        repository.delete(role);
    }

}
