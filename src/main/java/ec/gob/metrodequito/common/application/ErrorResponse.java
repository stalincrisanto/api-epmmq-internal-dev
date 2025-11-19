package ec.gob.metrodequito.common.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private boolean success;
    private String message;
    private String error;
    private int status;

    public static ErrorResponse of(String message, String error, int status) {
        return ErrorResponse.builder()
                .success(false)
                .message(message)
                .error(error)
                .status(status)
                .build();
    }
}