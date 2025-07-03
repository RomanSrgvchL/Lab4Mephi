package lab4.handler;

import jakarta.validation.ValidationException;
import lab4.dto.response.UserResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<UserResponseDto> handleValidationException(ValidationException e) {
        UserResponseDto response = new UserResponseDto(e.getMessage(), false);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
