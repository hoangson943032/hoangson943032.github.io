package com.springbootTest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootTest.entities.Teacher;



@Repository
public interface TeacherRepositories extends JpaRepository<Teacher, Integer> {

	@Query("SELECT t FROM Teacher t WHERE t.fullName LIKE %?1%")
	public List<Teacher> Search(String keyWord);

}
