package com.springbootTest.service;

import org.springframework.stereotype.Service;

import com.springbootTest.entities.Users;



@Service
public interface UserService {

    Users getByUserName(String UserName);
	
	Users getByEmail(String email);
	
	Boolean createUser(Users users);
}
