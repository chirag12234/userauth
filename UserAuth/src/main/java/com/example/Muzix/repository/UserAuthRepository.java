package com.example.Muzix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Muzix.model.User;

@Repository
public interface UserAuthRepository extends JpaRepository<User, String> {
	
	
	
	
	   User findByUserNameAndUserPassword(String userName, String userPassword);
}