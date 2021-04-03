package com.spring.restapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restapi.entities.UserEntity;
import com.spring.restapi.repository.UserRepository;
import com.spring.restapi.service.UserService;
import com.spring.restapi.ui.request.UserRequest;
import com.spring.restapi.ui.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto addUser) {

		if (userRepository.findByEmail(addUser.getEmail()) != null)
			throw new RuntimeException("User already exists.");

		UserEntity userEntity = new UserEntity();

		BeanUtils.copyProperties(addUser, userEntity);
		userEntity.setHashPassword("test");
		userEntity.setUserId("test");

		UserEntity storedUser = userRepository.save(userEntity);

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(storedUser, userDto);

		return userDto;
	}

//	@Override
//	public List<UserRequest> getAllUser() {
//
//		List<UserRequest> userList = userRepository.findAll();
//
//		return userList;
//	}
//
//	@Override
//	public UserRequest getUserById(long userId) {
//
//		UserRequest getUser = userRepository.getOne(userId);
//
//		return getUser;
//	}
//
//	
//	@Override
//	public UserRequest updateUserById(UserRequest updatedUser, long userId) {
//
//		UserRequest user = userRepository.getOne(userId);
//
//		user.setFirstName(updatedUser.getFirstName());
//		user.setLastName(updatedUser.getLastName());
//
//		userRepository.save(user);
//
//		return user;
//	}
//
//	@Override
//	public UserRequest deletedUserById(long userId) {
//
//		UserRequest deletedUser = userRepository.getOne(userId);
//
//		userRepository.delete(deletedUser);
//
//		return deletedUser;
//	}

}
