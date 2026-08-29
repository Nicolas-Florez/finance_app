package com.ravems.finance_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Usamos un Map para enviar la respuesta como: {"name": "El nombre es obligatorio"}
        Map<String, String> errors = new HashMap<>();

        // (En el siguiente paso extraeremos los mensajes de error para meterlos en el Map)
        for(FieldError error : ex.getBindingResult().getFieldErrors()){
            errors.put(error.getField(), error.getDefaultMessage());
        }

        // Retornamos el mapa de errores con su respectivo código HTTP
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}