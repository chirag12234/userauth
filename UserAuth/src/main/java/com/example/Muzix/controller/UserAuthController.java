package com.example.Muzix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Muzix.exception.UserAlreadyExistsException;
import com.example.Muzix.exception.UserNotFoundException;
import com.example.Muzix.model.User;
import com.example.Muzix.service.UserAuthServ;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins="http://localhost:4200")
public class UserAuthController {

	@Autowired
	UserAuthServ userAuthServ;
    public UserAuthController(UserAuthServ authicationService) {
		this.userAuthServ=authicationService;
	}

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
    	try {
    		userAuthServ.saveUser(user);
    		return new ResponseEntity<String>("User is saved",HttpStatus.CREATED);
    	}catch(UserAlreadyExistsException e) {
    		return new ResponseEntity<String>("User not saved",HttpStatus.CONFLICT);
    		
    	}
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
    	try {
    		String jwtToken ="";
    		userAuthServ.findByUserNameAndPassword(user.getuserName(),user.getUserPassword());
    		jwtToken = getToken(user.getuserName(), user.getUserPassword());
    		return new ResponseEntity<String>(jwtToken,HttpStatus.OK);
    	}catch(UserNotFoundException e) {
    		return new ResponseEntity<String>("User not saved",HttpStatus.UNAUTHORIZED);
    		
    	}catch(Exception e) {

    		return new ResponseEntity<String>("User not saved",HttpStatus.UNAUTHORIZED);

    	}
    }
    




// Generate JWT token
	public String getToken(String userName, String password) throws Exception {
		String jwtToken ="";
		jwtToken = Jwts.builder()
				   .setId(userName)
				   .setSubject(password)
				   .setIssuedAt(new Date())
				   .signWith(SignatureAlgorithm.HS256, "mykey")
				   .compact();

        return jwtToken;
        
        
}


}
