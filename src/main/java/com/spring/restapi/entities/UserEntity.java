package com.spring.restapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements Serializable {

	private static final long serialVersionUID = -7991169103144887313L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String userId;

	@Column(nullable = false, length = 30)
	private String firstName;

	@Column(nullable = false, length = 30)
	private String lastName;

	@Column(nullable = false, length = 40, unique = true)
	private String email;

	@Column(nullable = false)
	private String hashPassword;

	private String emailVerificationToken;

	@Column(nullable = false)
	private Boolean emailVerificationStatus = false;

}
