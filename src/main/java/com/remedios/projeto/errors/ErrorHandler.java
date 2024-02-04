package com.remedios.projeto.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleBadRequestException(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors();
        List<errorsData> errorsData = errors.stream().map(errorsData::new).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorsData);
    }

    public record errorsData(String msg, String field) {

        public errorsData(FieldError error) {
            this(error.getDefaultMessage(), error.getField());
        }
    }
}
