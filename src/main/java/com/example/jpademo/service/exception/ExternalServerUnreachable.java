package com.example.jpademo.service.exception;

public class ExternalServerUnreachable extends RuntimeException {
  
  public ExternalServerUnreachable() {
    super("External Server Unreachable");
  }
}
