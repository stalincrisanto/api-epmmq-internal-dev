package ec.gob.metrodequito.tarjetaoperacional.application.services;

import ec.gob.metrodequito.tarjetaoperacional.application.dto.CreateCardAssignmentHistoryDto;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.CreateOperationStaffDto;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.request.CardAssignmentRequest;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.CardAssignmentResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.OperationStaffResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.mapper.WebOperationStaffMapper;
import ec.gob.metrodequito.tarjetaoperacional.application.ports.in.CardAssignmentUseCase;
import ec.gob.metrodequito.tarjetaoperacional.application.ports.out.CardAssignmentHistoryPort;
import ec.gob.metrodequito.tarjetaoperacional.application.ports.out.OperationStaffPort;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.CardAssignmentHistory;
import ec.gob.metrodequito.tarjetaoperacional.domain.model.OperationStaff;
import ec.gob.metrodequito.tarjetaoperacional.utils.CardAssignmentStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CardAssignmentService implements CardAssignmentUseCase {
    private final OperationStaffPort operationStaffPort;
    private final CardAssignmentHistoryPort cardAssignmentHistoryPort;
    private final WebOperationStaffMapper mapper;

    @Override
    public OperationStaffResponse verifiedOperationStaffExists(String documentNumber) {
        return this.operationStaffPort.findByDocumentNumber(documentNumber)
                .map(operationStaff -> OperationStaffResponse.builder()
                        .exists(true)
                        .operationStaffDto(mapper.toDto(operationStaff))
                        .build())
                .orElse(OperationStaffResponse.builder()
                        .exists(false)
                        .operationStaffDto(null)
                        .build());
    }

    @Override
    public CardAssignmentResponse assignCardProcess(CardAssignmentRequest request) {
        OperationStaff staff = determineAndHandleStaff(request);

        CardAssignmentHistory cardAssignmentHistory = createAssignmentHistory(request, staff.getId());

        this.cardAssignmentHistoryPort.save(cardAssignmentHistory);

        return CardAssignmentResponse.builder()
                .isSuccessfully(true)
                .cardAssignationHistoryId(cardAssignmentHistory.getId())
                .operationStaffId(staff.getId())
                .build();
    }

    private OperationStaff determineAndHandleStaff (CardAssignmentRequest request) {
        String documentNumber = request.getDocumentNumber();
        if(request.getOperationStaffDto() == null){
            return this.operationStaffPort.findByDocumentNumber(documentNumber)
                    .orElseThrow(() -> new RuntimeException("error"));
        } else {
            return createNewOperationStaff(request.getOperationStaffDto(), documentNumber);
        }
    }

    private OperationStaff createNewOperationStaff (CreateOperationStaffDto staffDto, String documentNumber){
        // Validar que no exista persona con mismo documento
            /*if (operationStaffPort.existsByDocumentNumber(documentNumber)) {
                throw new DuplicateStaffException(
                        "Ya existe una persona con documento: " + documentNumber);
            }*/
        var staff = OperationStaff.builder()
                .name(staffDto.getName())
                .lastName(staffDto.getLastName())
                .email(staffDto.getEmail())
                .documentNumber(documentNumber)
                .departmentId(staffDto.getDepartmentId())
                .institutionalPositionId(staffDto.getInstitutionalPositionId())
                .build();
        return this.operationStaffPort.save(staff);
    }

    private CardAssignmentHistory  createAssignmentHistory (CardAssignmentRequest request, Long operationStaffId) {
        CreateCardAssignmentHistoryDto cardAssignmentHistory = request.getCardAssignmentHistoryDto();

        return CardAssignmentHistory.builder()
                .cardCode(cardAssignmentHistory.getCardCode())
                .reason(cardAssignmentHistory.getReason())
                .status(CardAssignmentStatus.ACTIVATED)
                .activationDate(LocalDateTime.now())
                .activatedById(cardAssignmentHistory.getActivatedById())
                .operationStaffId(operationStaffId)
                .build();
    }
}
