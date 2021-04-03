package com.spring.restapi.service;

import java.util.List;

import com.spring.restapi.entities.User;

public interface UserService {
	public List<User> getAllUser();

	public User getUserById(long userId);

	public User createUser(User newUser);

	public User updateUserById(User updatedUser, long userId);

	public User deletedUserById(long userId);

}
