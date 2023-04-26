package com.springbootTest.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootTest.entities.LopHoc;
import com.springbootTest.entities.Student;
import com.springbootTest.repositories.LopHocRepositories;
import com.springbootTest.repositories.StudentRepositories;
import com.springbootTest.service.StudentService;



@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	LopHocRepositories lopHocRepositories;
	
	@Autowired
	StudentRepositories studentRepositories;

	@Override
	public List<Student> getListStudent() {
		
		return studentRepositories.findAll();
	}

	@Override
	public Student createStudent(Student student, String className) {
		
		LopHoc lopHoc = lopHocRepositories.findByClassName(className);
		student.setLopHoc(lopHoc);
		
		return studentRepositories.save(student);
	}

	@Override
	public Student getById(Integer id) {
		
		return studentRepositories.findById(id).get();
	}

	@Override
	public void deleteStudent(Integer id) {
		Student dlStudent = studentRepositories.findById(id).get();
		 
		 studentRepositories.delete(dlStudent);	
	}

	@Override
	public boolean updateStudent(Student student, Integer id) {
		Student data = studentRepositories.findById(id).get();
		
		if (data!= null) {
			data.setFullName(student.getFullName());
			data.setAddress(student.getAddress());
			data.setDateOfBirth(student.getDateOfBirth());
			data.setGender(student.getGender());
			data.setPhone(student.getPhone());
			Student updateStudent = studentRepositories.save(student);
			return true;
		}

		return false;
	}

	
	

}
