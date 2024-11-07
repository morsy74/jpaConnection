package com.example.jpademo.service.exception;

public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(Long id) {
    super("Resource with Id: " + id + " not found!");
  }
  
}
