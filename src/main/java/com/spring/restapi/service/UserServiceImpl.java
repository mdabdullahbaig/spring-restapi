package com.spring.restapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restapi.entities.User;
import com.spring.restapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUser() {

		List<User> userList = userRepository.findAll();

		return userList;
	}

	@Override
	public User getUserById(long userId) {

		User getUser = userRepository.getOne(userId);

		return getUser;
	}

	@Override
	public User createUser(User newUser) {
		
		userRepository.save(newUser);
	
		return newUser;
	}

	@Override
	public User updateUserById(User updatedUser, long userId) {

		User user = userRepository.getOne(userId);

		user.setFirstName(updatedUser.getFirstName());
		user.setLastName(updatedUser.getLastName());

		userRepository.save(user);

		return user;
	}

	@Override
	public User deletedUserById(long userId) {

		User deletedUser = userRepository.getOne(userId);

		userRepository.delete(deletedUser);

		return deletedUser;
	}

}
