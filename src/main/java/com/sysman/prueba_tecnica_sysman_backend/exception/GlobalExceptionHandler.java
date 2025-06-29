package com.sysman.prueba_tecnica_sysman_backend.exception;

import com.sysman.prueba_tecnica_sysman_backend.constants.ExceptionMessages;
import com.sysman.prueba_tecnica_sysman_backend.constants.LogMessages;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MaterialNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleMaterialNotFound(MaterialNotFoundException ex) {

        log.warn(LogMessages.MATERIAL_NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(ExceptionMessages.MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(InvalidMaterialDatesException.class)
    public ResponseEntity<Map<String, String>> handleInvalidMaterialDates(InvalidMaterialDatesException ex) {

        log.warn(LogMessages.INVALID_MATERIAL_DATES, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(ExceptionMessages.MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolationException(ConstraintViolationException ex) {

        Map<String, String> errors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String[] pathElements = violation.getPropertyPath().toString().split("\\.");
            String paramName = pathElements[pathElements.length - 1];
            String message = violation.getMessage();
            errors.put(paramName, message);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception ex) {
        log.error(LogMessages.UNEXPECTED_ERROR, ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Collections.singletonMap(ExceptionMessages.MESSAGE, ExceptionMessages.UNEXPECTED_ERROR));
    }
}
