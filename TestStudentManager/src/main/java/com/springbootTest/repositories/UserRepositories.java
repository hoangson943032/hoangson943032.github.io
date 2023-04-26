package com.springbootTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.springbootTest.entities.Users;




@Repository
public interface UserRepositories extends JpaRepository<Users, Integer> {
	
//	@Query("SELECT u FROM Users u WHERE u.userName = ?1")
	Users findByUserName(String userName);

	Users findByEmail(String email);
}
