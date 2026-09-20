package dev.java10x.EventClean.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EventDuplicateException.class)
    public ResponseEntity<Map<String, String>> handleEventDuplicateException(EventDuplicateException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error: ", ex.getMessage());
        response.put("message: ", "Evento com identificador duplicado.");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
