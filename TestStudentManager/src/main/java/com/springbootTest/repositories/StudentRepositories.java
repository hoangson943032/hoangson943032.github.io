package com.springbootTest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootTest.entities.Student;




@Repository
public interface StudentRepositories extends JpaRepository<Student, Integer> {

	@Query("SELECT s FROM Student s WHERE s.fullName LIKE %?1%")
	public List<Student> Search(String keyWord);
}
