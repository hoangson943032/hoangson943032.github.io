package com.springbootTest.service;

import java.util.List;

import com.springbootTest.entities.Teacher;



public interface TeacherService {

	List<Teacher> getListTeacher();

	Teacher createTeacher(Teacher teacher, String className);

	Teacher getById(Integer Id);

	void deleteTeacher(Integer ids);

	boolean updateTeacher(Teacher teacher, Integer id);
}
