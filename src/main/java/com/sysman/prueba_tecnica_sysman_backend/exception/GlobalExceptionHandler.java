package com.sysman.prueba_tecnica_sysman_backend.exception;

import com.sysman.prueba_tecnica_sysman_backend.constants.ExceptionMessages;
import com.sysman.prueba_tecnica_sysman_backend.constants.LogMessages;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCityNotFound(CityNotFoundException ex) {

        log.warn(LogMessages.CITY_NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(ExceptionMessages.MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(InvalidMaterialDatesException.class)
    public ResponseEntity<Map<String, String>> handleInvalidMaterialDates(InvalidMaterialDatesException ex) {

        log.warn(LogMessages.INVALID_MATERIAL_DATES, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(ExceptionMessages.MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(DuplicateMaterialException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateMaterial(DuplicateMaterialException ex) {

        log.warn(LogMessages.DUPLICATE_MATERIAL, ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(ExceptionMessages.MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRoleNotFound(RoleNotFoundException ex) {

        log.warn(LogMessages.ROLE_NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap(ExceptionMessages.MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExists(UserAlreadyExistsException ex) {

        log.warn(LogMessages.USER_ALREADY_EXISTS, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Collections.singletonMap(ExceptionMessages.MESSAGE, ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(ExceptionMessages.MESSAGE, ExceptionMessages.INVALID_DATE_FORMAT));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidFormat(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap(ExceptionMessages.MESSAGE, ExceptionMessages.INVALID_DATE_FORMAT));
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

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<Map<String, String>> handleGenericException(AuthorizationDeniedException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(Collections.singletonMap(ExceptionMessages.MESSAGE, ExceptionMessages.FORBIDDEN));
    }
}
