package com.example.Muzix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Muzix.model.User;
import com.stackroute.keepnote.exception.UserAlreadyExistsException;
import com.stackroute.keepnote.exception.UserNotFoundException;
import com.stackroute.keepnote.service.UserAuthenticationService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class UserAuthController {
	
	 @PostMapping("/register")
	 
	 
	 @PostMapping("/login")
	
	
	
	
	// Generate JWT token
	
}