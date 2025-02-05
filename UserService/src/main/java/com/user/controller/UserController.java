package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.userservice.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	//create user
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1= userService.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	//get all user
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUsers =userService.getAllUser();
		return ResponseEntity.ok(allUsers);
	}
	
	//get single user
	@GetMapping("/getsingle/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable("userId") String userId)
	{
		User user =userService.getSingleUser(userId);
		return ResponseEntity.ok(user);
	}
}
