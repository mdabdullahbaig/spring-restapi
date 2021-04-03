package com.spring.restapi.service;

import java.util.List;

import com.spring.restapi.ui.request.UserRequest;
import com.spring.restapi.ui.shared.dto.UserDto;

public interface UserService {
//	public List<UserRequest> getAllUser();
//
//	public UserRequest getUserById(long userId);

	UserDto createUser(UserDto addUser);

//	public UserRequest updateUserById(UserRequest updatedUser, long userId);
//
//	public UserRequest deletedUserById(long userId);

}
