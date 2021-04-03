package com.spring.restapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.restapi.entities.User;

@Service
public class UserServiceImplWithOutJpa implements UserServiceWithOutJpa {

	List<User> userList;

	public UserServiceImplWithOutJpa() {

		userList = new ArrayList<>();
		userList.add(new User(1, "Md Abdullah", "Baig", "abdullah@gmail.com", "abdul123"));
		userList.add(new User(2, "Md Arshad", "Baig", "arshad@gmail.com", "arshad123"));
		userList.add(new User(3, "Md Tahir", "Baig", "tahir@gmail.com", "tahir123"));
	}

	@Override
	public List<User> getAllUser() {

		return userList;
	}

	@Override
	public User getUserById(long userId) {

		User getUser = null;

		for (User user : userList) {
			if (user.getId() == userId) {
				getUser = user;
				break;
			}
		}
		return getUser;
	}

	@Override
	public User createUser(User newUser) {
		userList.add(newUser);
		return newUser;
	}

	@Override
	public User updateUserById(User updatedUser, long userId) {

		User updateUser = null;

		for (User user : userList) {
			if (user.getId() == userId) {
				user.setFirstName(updatedUser.getFirstName());
				user.setLastName(updatedUser.getLastName());
				updateUser = user;
				break;
			}
		}
		return updateUser;
	}

	@Override
	public User deletedUserById(long userId) {
		
		User deleteUser = null;

		for (User user : userList) {
			if (user.getId() == userId) {
				deleteUser = user;
				userList.remove(user);
				break;
			}
		}

		return deleteUser;
	}

}
