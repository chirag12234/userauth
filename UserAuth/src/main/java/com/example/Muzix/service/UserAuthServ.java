package com.example.Muzix.service;

import com.example.Muzix.exception.UserAlreadyExistsException;
import com.example.Muzix.exception.UserNotFoundException;
import com.example.Muzix.model.User;

public interface UserAuthServ {

    	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

    public User findByUserNameAndPassword(String userName, String password) throws UserNotFoundException;

    boolean saveUser(User user) throws UserAlreadyExistsException;
}
