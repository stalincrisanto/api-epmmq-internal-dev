package ec.gob.metrodequito.common.infraestructure;

import ec.gob.metrodequito.common.application.ApiResponse;
import ec.gob.metrodequito.common.application.ErrorDetail;
import ec.gob.metrodequito.common.application.ErrorResponse;
import ec.gob.metrodequito.tarjetaoperacional.domain.exceptions.CardNotAssignedException;
import ec.gob.metrodequito.tarjetaoperacional.domain.exceptions.DataDiscrepancyException;
import ec.gob.metrodequito.tarjetaoperacional.domain.exceptions.DataInconsistencyException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponse errorResponse = ErrorResponse.builder()
                .success(false)
                .error(ErrorDetail.builder()
                        .code("VALIDATION_ERROR")
                        .message("Error de validación")
                        .details(Map.of("validationErrors", String.join(", ", errors)))
                        .timestamp(Instant.now().toString())
                        .path(getRequestPath(request))
                        .build())
                .build();

        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(CardNotAssignedException.class)
    public ResponseEntity<ErrorResponse> handleCardNotAssignedException(CardNotAssignedException ex, WebRequest request) {
        ErrorResponse errorResponse = buildErrorResponse(
                ex.getMessage(),
                "HTTP_404",
                "cardCode",
                getRequestPath(request)
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(DataDiscrepancyException.class)
    public ResponseEntity<ErrorResponse> handleDataDiscrepancyException(DataDiscrepancyException ex, WebRequest request) {
        ErrorResponse errorResponse = buildErrorResponse(
                ex.getMessage(),
                "HTTP_409",
                "cardCode",
                getRequestPath(request)
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(DataInconsistencyException.class)
    public ResponseEntity<ErrorResponse> handleDataInconsistencyException(DataInconsistencyException ex, WebRequest request) {
        ErrorResponse errorResponse = buildErrorResponse(
                ex.getMessage(),
                "HTTP_409",
                "documentId",
                getRequestPath(request)
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    private ErrorResponse buildErrorResponse(String message, String code, String type, String path) {
        return ErrorResponse.builder()
                .success(false)
                .error(ErrorDetail.builder()
                        .code(code)
                        .message(message)
                        .details(Map.of("type", type))
                        .timestamp(Instant.now().toString())
                        .path(path)
                        .build())
                .build();
    }

    private String getRequestPath(WebRequest request) {
        if (request instanceof ServletWebRequest) {
            HttpServletRequest servletRequest = ((ServletWebRequest) request).getRequest();
            return servletRequest.getRequestURI() +
                    (servletRequest.getQueryString() != null ? "?" + servletRequest.getQueryString() : "");
        }
        return "";
    }
}
