package ec.gob.metrodequito.tarjetaoperacional.application.services;

import ec.gob.metrodequito.controlacceso.domain.models.Department;
import ec.gob.metrodequito.controlacceso.domain.models.InstitutionalPosition;
import ec.gob.metrodequito.controlacceso.domain.services.DepartmentService;
import ec.gob.metrodequito.controlacceso.domain.services.InstitutionalPositionService;
import ec.gob.metrodequito.sistemacentralrecaudo.application.dto.CardActivationRequest;
import ec.gob.metrodequito.sistemacentralrecaudo.application.ports.out.CardActivationPort;
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
import java.util.Optional;

@AllArgsConstructor
@Service
public class CardAssignmentService implements CardAssignmentUseCase {
    private final OperationStaffPort operationStaffPort;
    private final CardAssignmentHistoryPort cardAssignmentHistoryPort;
    private final WebOperationStaffMapper mapper;

    private final DepartmentService departmentPort;
    private final InstitutionalPositionService positionPort;

    private final CardActivationPort cardActivationPort;

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

        CardActivationRequest cardActivationRequest = createCardActivationInfo(staff, cardAssignmentHistory);

        cardActivationPort.activateCard(cardActivationRequest);

        return CardAssignmentResponse.builder()
                .isSuccessfully(true)
                .cardAssignationHistoryId(cardAssignmentHistory.getId())
                .operationStaffId(staff.getId())
                .build();
    }

    private OperationStaff determineAndHandleStaff(CardAssignmentRequest request) {
        String documentNumber = request.getDocumentNumber();
        if (request.getStaff() == null) {
            return this.operationStaffPort.findByDocumentNumber(documentNumber)
                    .orElseThrow(() -> new RuntimeException("error"));
        } else {
            return createNewOperationStaff(request.getStaff(), documentNumber);
        }
    }

    private OperationStaff createNewOperationStaff(CreateOperationStaffDto staffDto, String documentNumber) {
        Optional<Department> department = this.departmentPort.getById(staffDto.getDepartmentId());
        Optional<InstitutionalPosition> position = this.positionPort.getById(staffDto.getInstitutionalPositionId());
        var staff = OperationStaff.builder()
                .name(staffDto.getName())
                .lastName(staffDto.getLastName())
                .email(staffDto.getEmail())
                .documentNumber(documentNumber)
                .phoneNumber(staffDto.getPhoneNumber())
                .department(department.orElse(null))
                .institutionalPosition(position.orElse(null))
                .build();

        return this.operationStaffPort.save(staff);
    }

    private CardAssignmentHistory createAssignmentHistory(CardAssignmentRequest request, Long operationStaffId) {
        CreateCardAssignmentHistoryDto cardAssignmentHistory = request.getAssignment();
        Optional<OperationStaff> operationStaff = operationStaffPort.getById(operationStaffId);
        System.out.println("operationStaff-------------->" + operationStaff.orElse(null));
        var assignment = CardAssignmentHistory.builder()
                .cardCode(cardAssignmentHistory.getCardCode())
                .reason(cardAssignmentHistory.getReason())
                .status(CardAssignmentStatus.ACTIVATED)
                .activationDate(LocalDateTime.now())
                .expirationDate(cardAssignmentHistory.getExpirationDate())
                .activatedById(cardAssignmentHistory.getActivatedById())
                .operationStaff(operationStaff.orElse(null))
                .build();
        System.out.println("LUEGO DE MAPEAR-------------->" + assignment);

        return this.cardAssignmentHistoryPort.save(assignment);
    }

    private CardActivationRequest createCardActivationInfo(OperationStaff operationStaff, CardAssignmentHistory cardAssignmentHistory) {
        return CardActivationRequest.builder()
                .name(operationStaff.getName())
                .lastName(operationStaff.getLastName())
                .codActivation(cardAssignmentHistory.getCardCode())
                .documentId(operationStaff.getDocumentNumber())
                .expirationDate(String.valueOf(cardAssignmentHistory.getExpirationDate()))
                .build();
    }
}
