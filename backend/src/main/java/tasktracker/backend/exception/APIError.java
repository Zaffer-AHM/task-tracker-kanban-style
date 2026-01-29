package tasktracker.backend.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
public class APIError {
    private int status;
    private String code;
    private String message;
    private String detail;
    private String path;
    private LocalDateTime timestamp;

    public APIError(int status, String code, String message, String detail, String path) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.detail = detail;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }
}
