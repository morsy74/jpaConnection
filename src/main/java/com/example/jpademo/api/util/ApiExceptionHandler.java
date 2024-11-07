package com.example.jpademo.api.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.jpademo.service.exception.ResourceNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler {
  
  @ExceptionHandler({ResourceNotFoundException.class})
  public ResponseEntity <?> handlerResourceNotFound(ResourceNotFoundException ex) {
    ErrorResponse errorResponse = new ErrorResponse(12, ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
  }
}
