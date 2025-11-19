package ec.gob.metrodequito.tarjetaoperacional.infraestructure.controllers;

import ec.gob.metrodequito.common.application.ApiResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.dto.response.OperationStaffResponse;
import ec.gob.metrodequito.tarjetaoperacional.application.services.CardAssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operation-staff")
@RequiredArgsConstructor
public class CardAssignmentController {

    private final CardAssignmentService cardAssignmentService;

    @GetMapping("/verify/{documentNumber}")
    public ResponseEntity<ApiResponse<OperationStaffResponse>> verifyStaffExistence(
            @PathVariable String documentNumber) {
        OperationStaffResponse response = cardAssignmentService.verifiedOperationStaffExists(documentNumber);
        String message = response.isExists()
                ? "Persona encontrada en el sistema"
                : "Persona no encontrada en el sistema";

        return ResponseEntity.ok(ApiResponse.success(response, message));
    }

}
