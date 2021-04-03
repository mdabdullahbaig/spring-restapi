package com.spring.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.restapi.entities.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByEmail(String email);
}
