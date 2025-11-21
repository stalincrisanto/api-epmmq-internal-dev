package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.domain.mappers.PersistenceDeparmentMapper;
import ec.gob.metrodequito.controlacceso.domain.models.Department;
import ec.gob.metrodequito.controlacceso.domain.repositories.DepartmentsRepository;
import ec.gob.metrodequito.controlacceso.domain.repositories.UsersRepository;
import ec.gob.metrodequito.controlacceso.domain.services.dto.UsersDto;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Departments;
import ec.gob.metrodequito.controlacceso.infrastructure.databases.entities.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentsRepository repository;
    private final PersistenceDeparmentMapper persistenceDeparmentMapper;

    @Override
    public Optional<Department> getById(Integer id) {
        return repository.findById(id).map(persistenceDeparmentMapper::toDomain);
    }
}
