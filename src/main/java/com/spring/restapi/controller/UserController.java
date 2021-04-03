package com.spring.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.entities.User;
import com.spring.restapi.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUser() {
		List<User> userList = this.userService.getAllUser();

		if (userList.size() <= 0)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId) {
		
		User user = this.userService.getUserById(Long.parseLong(userId));
		
		if(user == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
		User user = this.userService.createUser(newUser);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
				
	}

	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUserById(@RequestBody User updatedUser, @PathVariable String userId) {
		User user = this.userService.updateUserById(updatedUser, Long.parseLong(userId));
		
		if(user == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<User> deletedUserById(@PathVariable String userId) {
		
		
		try {
			User user = this.userService.deletedUserById(Long.parseLong(userId));
			if(user == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
}
