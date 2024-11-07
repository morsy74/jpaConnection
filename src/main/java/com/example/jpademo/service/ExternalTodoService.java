package com.example.jpademo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.jpademo.service.exception.ExternalServerUnreachable;
import com.example.jpademo.service.util.TodoResponse;

@Service
public class ExternalTodoService {

  private final RestTemplate restTemplate;

  public ExternalTodoService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }
  public List<TodoResponse> getUserTodo(Long id) {

    ResponseEntity<TodoResponse[]> responseEntity = restTemplate.getForEntity("https://gist.github.com/freshcutdevelopment/16d1d0df5b313affd5fd#file-todo-json", TodoResponse[].class);
    if (responseEntity.getStatusCode().is2xxSuccessful()) {
      return new ArrayList<>(Arrays.asList(Objects.requireNonNull(responseEntity.getBody())));
    }
    else {
      throw new ExternalServerUnreachable();
    }
  }
}
