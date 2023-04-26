package com.springbootTest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootTest.entities.LopHoc;





@Repository
public interface LopHocRepositories  extends JpaRepository<LopHoc, Integer> {
	
	LopHoc findByClassName(String className);

}
