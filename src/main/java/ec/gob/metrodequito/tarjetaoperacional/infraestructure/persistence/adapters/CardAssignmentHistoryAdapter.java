package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.adapters;

import ec.gob.metrodequito.tarjetaoperacional.application.ports.out.CardAssignmentHistoryPort;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.CardAssignmentHistory;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.CardAssignmentHistoryEntity;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.mappers.PersistenceCardAssignmentHistoryMapper;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.repository.CardAssignmentHistoryRepository;
import ec.gob.metrodequito.tarjetaoperacional.utils.CardAssignmentStatus;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CardAssignmentHistoryAdapter implements CardAssignmentHistoryPort {

    private final CardAssignmentHistoryRepository repository;
    private final PersistenceCardAssignmentHistoryMapper mapper;

    @Override
    public CardAssignmentHistory save(CardAssignmentHistory cardAssignmentHistory) {
        CardAssignmentHistoryEntity entity = this.mapper.toEntity(cardAssignmentHistory);
        return this.mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<CardAssignmentHistory> findActiveByCardCode(String cardCode) {
        Optional<CardAssignmentHistoryEntity> entity = repository.findByCardCodeAndStatus(cardCode, CardAssignmentStatus.ACTIVATED);
        System.out.println("EN EL REPOSITORIO--------------->"+entity.get().getOperationsStaff().getDepartment().getName());

        return entity.map(this.mapper::toDomain);
    }

    @Override
    public Optional<CardAssignmentHistory> findActiveByDocumentNumber(String documentNumber) {
        Optional<CardAssignmentHistoryEntity> entity = repository.findByOperationStaffDocumentNumberAndStatus(documentNumber, CardAssignmentStatus.ACTIVATED);
        System.out.println("EN EL REPOSITORIO--------------->"+entity.get().getOperationsStaff().getId());
        return entity.map(this.mapper::toDomain);
    }
}
