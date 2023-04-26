package com.springbootTest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootTest.entities.AdminUserDetails;
import com.springbootTest.entities.Users;
import com.springbootTest.exception.NotFoundException;
import com.springbootTest.repositories.UserRepositories;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepositories userRepositories;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users users = userRepositories.findByUserName(username);
		if(users == null) {
			throw new NotFoundException(username + " User not found!");
		}
		List<String> roleName = new ArrayList<String>();
		roleName.add(users.getRoles());
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		if (roleName != null) {
			for (String role : roleName) {
				
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantList.add(authority);
			}
		}
		UserDetails userDetails = (UserDetails) new AdminUserDetails(users.getUserName(), users.getPassword(), users.getEmail(), users.getUserID(), grantList);
		
		return userDetails;
	}

}
