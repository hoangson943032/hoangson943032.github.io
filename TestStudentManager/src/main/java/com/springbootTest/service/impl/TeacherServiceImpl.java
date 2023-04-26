package com.springbootTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootTest.entities.LopHoc;
import com.springbootTest.entities.Teacher;
import com.springbootTest.repositories.LopHocRepositories;
import com.springbootTest.repositories.TeacherRepositories;
import com.springbootTest.service.TeacherService;


@Service
public class TeacherServiceImpl implements TeacherService {

	
	@Autowired
	LopHocRepositories lopHocRepositories;
	
	@Autowired
	TeacherRepositories teacherRepositories;
	
	@Override
	public Teacher createTeacher(Teacher teacher, String className) {

		
		LopHoc lopHoc = lopHocRepositories.findByClassName(className);
		teacher.setLopHoc(lopHoc);
		
		return teacherRepositories.save(teacher);
	}


	@Override
	public List<Teacher> getListTeacher() {

		return teacherRepositories.findAll();
	}
	
	@Override
	public Teacher getById(Integer Id) {

		return teacherRepositories.findById(Id).get();
	}

	@Override
	public void deleteTeacher(Integer ids) {
		
		Teacher dlTeacher = teacherRepositories.findById(ids).get();
		 
		teacherRepositories.delete(dlTeacher);	
	}

	@Override
	public boolean updateTeacher(Teacher teacher, Integer id) {
		
		Teacher data = teacherRepositories.findById(id).get();
		
		if (data!= null) {
			data.setFullName(teacher.getFullName());
			data.setPosition(teacher.getPosition());
			data.setDateOfBirth(teacher.getDateOfBirth());
			data.setPhone(teacher.getPhone());
			
			Teacher updateTeacher = teacherRepositories.save(teacher);
			return true;
		}
		return false;
		
	}

	

	
}
