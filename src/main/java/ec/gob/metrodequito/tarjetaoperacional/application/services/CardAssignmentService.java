package ec.gob.metrodequito.tarjetaoperacional.application.services;

import ec.gob.metrodequito.tarjetaoperacional.application.dto.OperationStaffDto;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.OperationStaffResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.mapper.WebOperationStaffMapper;
import ec.gob.metrodequito.tarjetaoperacional.application.ports.in.CardAssignmentUseCase;
import ec.gob.metrodequito.tarjetaoperacional.application.ports.out.OperationStaffPort;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CardAssignmentService implements CardAssignmentUseCase {
    private final OperationStaffPort operationStaffPort;
    private final WebOperationStaffMapper mapper;

    @Override
    public OperationStaffResponse verifiedOperationStaffExists(String documentNumber) {
        Optional<OperationStaff> existingStaff = this.operationStaffPort.findByDocumentNumber(documentNumber);
        if(existingStaff.isPresent()){
            OperationStaff operationStaff = existingStaff.get();
            OperationStaffDto dto = mapper.toDto(operationStaff);
            return OperationStaffResponse.builder()
                    .exists(true)
                    .operationStaffDto(dto)
                    .build();
        } else {
            return OperationStaffResponse.builder()
                    .exists(false)
                    .operationStaffDto(null)
                    .build();
        }
    }
}
