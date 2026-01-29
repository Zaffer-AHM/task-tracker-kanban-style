package tasktracker.backend.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIError> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        APIError error = new APIError(
                HttpStatus.BAD_REQUEST.value(),
                "VALIDATION_ERROR",
                "validation failed",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIError> handleNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        APIError error = new APIError(
                HttpStatus.NOT_FOUND.value(),
                "RESOURCE_NOT_FOUND",
                "resource_not_found",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<APIError> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        APIError error = new APIError(
                HttpStatus.BAD_REQUEST.value(),
                "BAD_REQUEST",
                "bad_request",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
