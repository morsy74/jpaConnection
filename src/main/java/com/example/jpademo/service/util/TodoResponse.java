package com.example.jpademo.service.util;

import lombok.Data;

@Data
public class TodoResponse {
  private Long id;
  private Long userId;
  private String title;
  private boolean completed;

}
