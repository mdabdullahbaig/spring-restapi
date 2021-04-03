package com.spring.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restapi.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmail(String email);
	public User findByPassword(String password);
}
