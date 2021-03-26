package com.example.Muzix.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.Muzix.exception.UserAlreadyExistsException;
import com.example.Muzix.exception.UserNotFoundException;
import com.example.Muzix.model.User;
import com.example.Muzix.repository.UserAuthRepository;

@Service
public class UserAuthServiceImpl implements UserAuthServ {

	@Autowired
    UserAuthRepository userAuthRepo;
	 public UserAuthServiceImpl(UserAuthRepository userAuthRepo){
		   this.userAuthRepo=userAuthRepo;
		   }

    @Override
    public User findByUserNameAndPassword(String userName, String password) throws UserNotFoundException {
    	User newUser=userAuthRepo.findByUserNameAndUserPassword(userName, password);
    	if(newUser!=null) {
    		return newUser;
    	}
    	else {
    		throw new UserNotFoundException("Not Found");
    	}
      
       
    }

    @Override
    public boolean saveUser(User user) throws UserAlreadyExistsException {
    	//boolean status=false;
		Optional<User> newUser=userAuthRepo.findById(user.getuserName());
	//	try {
        if(newUser.isPresent()) {
        	throw new UserAlreadyExistsException("User Already Exists Exception");
        	
        }
        userAuthRepo.save(user);
    	return true;
}
}
