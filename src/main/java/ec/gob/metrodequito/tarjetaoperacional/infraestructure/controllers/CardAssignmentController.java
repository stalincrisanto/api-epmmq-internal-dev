package ec.gob.metrodequito.tarjetaoperacional.infraestructure.controllers;

import ec.gob.metrodequito.common.application.ApiResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.request.CardAssignmentRequest;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.CardAssignmentResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.OperationStaffResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.services.CardAssignmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assignment-card")
@RequiredArgsConstructor
public class CardAssignmentController {

    private final CardAssignmentService cardAssignmentService;

    @GetMapping("/verify-staff/{documentNumber}")
    public ResponseEntity<ApiResponse<OperationStaffResponse>> verifyStaffExistence(
            @PathVariable String documentNumber) {
        OperationStaffResponse response = cardAssignmentService.verifiedOperationStaffExists(documentNumber);
        String message = response.isExists()
                ? "Persona encontrada en el sistema"
                : "Persona no encontrada en el sistema";

        return ResponseEntity.ok(ApiResponse.success(response, message));
    }

    @PostMapping("/assign-to-staff")
    public ResponseEntity<ApiResponse<CardAssignmentResponse>> assignCard (
            @Valid @RequestBody CardAssignmentRequest request
            ){
        CardAssignmentResponse response = this.cardAssignmentService.assignCardProcess(request);
        return ResponseEntity.ok(ApiResponse.success(response, "Se ha asignado correctamente"));
    }

}
