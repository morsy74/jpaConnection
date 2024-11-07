package com.example.jpademo.api.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpademo.api.dto.RegisterDto;
import com.example.jpademo.service.ExternalTodoService;
import com.example.jpademo.service.UserService;

@RestController
@RequestMapping("/api/users")

public class UserController {

	private final UserService userService;
	private final ExternalTodoService externalTodoService;

	public UserController(UserService userService, ExternalTodoService externalTodoService) {
		this.userService = userService;
		this.externalTodoService = externalTodoService;
		
	}

	@GetMapping("/allUsers")
	public ResponseEntity<?> getAllUsers() {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(userService.getAllUsers());
	}

	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody RegisterDto registerDto) {
		return ResponseEntity
			.status(HttpStatus.CREATED)
			.body(userService.addUser(registerDto.getUsername(), registerDto.getPassword()));

	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(userService.getUserById(id));
	}

	@GetMapping("/getUserById/{id}/todos")
	public ResponseEntity<?> getUserTodosById(@PathVariable Long id) {
		return ResponseEntity
			.status(HttpStatus.OK)
			.body(externalTodoService.getUserTodo(id));
	}
}
