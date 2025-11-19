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
public class ApiResponse <T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> ApiResponse<T> success (T data, String message){
        return ApiResponse.<T>builder()
                .success(true)
                .message(message)
                .data(data)
                .build();
    }

    public static ApiResponse<?> error(String message) {
        return ApiResponse.builder()
                .success(false)
                .message(message)
                .data(null)
                .build();
    }
}
