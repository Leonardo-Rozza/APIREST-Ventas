package com.api_ventas.presentation.advice;

import com.api_ventas.presentation.exeptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GenericExeptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public Map<String, String> handleInvalidArguments(MethodArgumentNotValidException e){
    Map<String , String> errors = new HashMap<>();
    e.getBindingResult().getFieldErrors().forEach(error -> {
      errors.put(error.getField(), error.getDefaultMessage());
    });
    return errors;
  }

  // Manejo de errores cuando un recurso no existe
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<Map<String, String>> handleResourceNotFoundException(ResourceNotFoundException e) {
    Map<String, String> error = new HashMap<>();
    error.put("error", e.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

  // Manejo de errores generales (ej: stock insuficiente)
  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<Map<String, String>> handleIllegalArgumentException(IllegalArgumentException e) {
    Map<String, String> error = new HashMap<>();
    error.put("error", e.getMessage());
    return ResponseEntity.badRequest().body(error);
  }


}
