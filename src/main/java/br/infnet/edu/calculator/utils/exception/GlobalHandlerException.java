package br.infnet.edu.calculator.utils.exception;

import br.infnet.edu.calculator.dto.ApiResponse;
import br.infnet.edu.calculator.utils.messages.ErrorCode;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ApiResponse<Void>> handleArithmetic(ArithmeticException ex) {
        return ResponseEntity.badRequest().body(ApiResponse.error(ErrorCode.DIVIDE_BY_ZERO));
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ApiResponse<Void>> handleValidation() {
        return ResponseEntity.badRequest().body(ApiResponse.error(ErrorCode.VALIDATION_ERROR));
    }
}