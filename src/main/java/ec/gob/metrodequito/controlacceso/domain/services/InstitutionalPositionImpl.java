package ec.gob.metrodequito.controlacceso.domain.services;

import ec.gob.metrodequito.controlacceso.domain.mappers.PersistenceDeparmentMapper;
import ec.gob.metrodequito.controlacceso.domain.mappers.PersistenceInstitutionalPositionMapper;
import ec.gob.metrodequito.controlacceso.domain.models.Department;
import ec.gob.metrodequito.controlacceso.domain.models.InstitutionalPosition;
import ec.gob.metrodequito.controlacceso.domain.repositories.DepartmentsRepository;
import ec.gob.metrodequito.controlacceso.domain.repositories.InstitucionalPositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstitutionalPositionImpl implements InstitutionalPositionService {
    private final InstitucionalPositionRepository repository;
    private final PersistenceInstitutionalPositionMapper persistencePositionMapper;

    @Override
    public Optional<InstitutionalPosition> getById(Integer id) {
        return repository.findById(id).map(persistencePositionMapper::toDomain);
    }
}
