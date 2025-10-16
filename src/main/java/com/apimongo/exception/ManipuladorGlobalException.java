package com.apimongo.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ManipuladorGlobalException {
    @ExceptionHandler(JSONException.class)
    public ResponseEntity<?> handleJSONException(JSONException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: " + ex.getMessage());
    }

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<?> handleJsonProcessingException(JsonProcessingException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: " + ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro: " + ex.getMessage());
    }
}
