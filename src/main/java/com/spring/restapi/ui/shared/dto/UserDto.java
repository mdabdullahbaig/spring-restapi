package com.spring.restapi.ui.shared.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
	private static final long serialVersionUID = -7416890855171087543L;
	private long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String hashPassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus = false;
	
}
