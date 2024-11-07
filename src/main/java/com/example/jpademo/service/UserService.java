package com.example.jpademo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.jpademo.database.entity.User;
import com.example.jpademo.database.repo.UserRepository;
import com.example.jpademo.service.exception.ResourceNotFoundException;
import com.example.jpademo.service.util.UserResponse;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserResponse addUser(String username, String password) {
		User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(password);
    User savedUser = userRepository.save(newUser);
    UserResponse userResponse = new UserResponse();
    userResponse.setId(savedUser.getId());
    userResponse.setUsername(savedUser.getUsername());
    return userResponse;
	}

	public List<UserResponse> getAllUsers() {
		List<UserResponse> userResponses = new ArrayList<>();
		List<User> allUsers = userRepository.findAll();
		for (User user : allUsers) {
			UserResponse response = new UserResponse();
      response.setId(user.getId());
      response.setUsername(user.getUsername());
      userResponses.add(response);
		}
		return userResponses;
	}

	public UserResponse getUserById(Long id) {
		User user = userRepository.findById(id)
		  .orElseThrow(() -> new ResourceNotFoundException(id));
		UserResponse userResponse = new UserResponse();
		userResponse.setId(user.getId());
		userResponse.setUsername(user.getUsername());
		return userResponse;
	}
	
}
