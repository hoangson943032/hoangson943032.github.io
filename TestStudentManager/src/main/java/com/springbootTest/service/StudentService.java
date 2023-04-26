package com.springbootTest.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springbootTest.entities.Student;



public interface StudentService {

	List<Student> getListStudent();

	Student createStudent(Student student, String className);

	Student getById(Integer id);

	void deleteStudent(Integer id);

	boolean updateStudent(Student student, Integer id);
}
