package ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.adapters;

import ec.gob.metrodequito.tarjetaoperacional.application.ports.out.CardAssignmentHistoryPort;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.CardAssignmentHistory;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.entities.CardAssignmentHistoryEntity;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.mappers.PersistenceCardAssignmentHistoryMapper;
import ec.gob.metrodequito.tarjetaoperacional.infraestructure.persistence.repository.CardAssignmentHistoryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CardAssignmentHistoryAdapter implements CardAssignmentHistoryPort {

    private CardAssignmentHistoryRepository repository;
    private PersistenceCardAssignmentHistoryMapper mapper;

    @Override
    public CardAssignmentHistory save(CardAssignmentHistory cardAssignmentHistory) {
        CardAssignmentHistoryEntity entity = this.mapper.toEntity(cardAssignmentHistory);
        return this.mapper.toDomain(repository.save(entity));
    }
}
