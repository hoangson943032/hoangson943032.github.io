package com.springbootTest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootTest.entities.Users;
import com.springbootTest.repositories.UserRepositories;
import com.springbootTest.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepositories userRepositories;
	
	@Override
	public Users getByUserName(String UserName) {
		return userRepositories.findByUserName(UserName);
	}

	@Override
	public Users getByEmail(String email) {
		return userRepositories.findByEmail(email);
	}

	@Override
	public Boolean createUser(Users users) {
		return userRepositories.save(users) != null;
	}

}
