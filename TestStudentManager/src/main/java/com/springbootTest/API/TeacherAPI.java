package com.springbootTest.API;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootTest.dto.StudentDto;
import com.springbootTest.dto.TeacherDto;
import com.springbootTest.entities.Student;
import com.springbootTest.entities.Teacher;
import com.springbootTest.repositories.LopHocRepositories;
import com.springbootTest.service.TeacherService;

@RestController
public class TeacherAPI {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private LopHocRepositories lopHocRepositories;
	
	@PostMapping(value = "/teacher")
	public ResponseEntity<TeacherDto> addTeacher(@Valid @RequestBody TeacherDto teacherDto) {
		
		// convert DTO to entity
		Teacher teacherRequest = modelMapper.map(teacherDto, Teacher.class);
		
		Teacher teacher = teacherService.createTeacher(teacherRequest, teacherDto.getClassName());

		// convert entity to DTO
		TeacherDto TeacherResponse = modelMapper.map(teacher, TeacherDto.class);
		
		return new ResponseEntity<TeacherDto>(TeacherResponse, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/teacher")
	public ResponseEntity<List<Teacher>> getListTeacher(){
		
		List<Teacher> teachers = teacherService.getListTeacher();
		
		if (teachers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Teacher>>(teachers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/teacher/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer id){
		
		Teacher teacher = teacherService.getById(id);
		
		if (teacher == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(teacher, HttpStatus.OK);
	}
	
	@PutMapping(value = "/teacher/{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable(value = "id") Integer id, @Valid @RequestBody Teacher teacherForm, TeacherDto teacherDto){
		
		Teacher teacher = teacherService.getById(id);
		if (teacher == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		teacher.setFullName(teacherForm.getFullName());
		teacher.setPosition(teacherForm.getPosition());
		teacher.setDateOfBirth(teacherForm.getDateOfBirth());
		teacher.setPhone(teacherForm.getPhone());
		
		Teacher updateTeacher = teacherService.createTeacher(teacher, teacherDto.getClassName());
		return new ResponseEntity<>(updateTeacher, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/teacher/{id}")
	public void deleteStudent(@PathVariable(value = "id") Integer id){

		teacherService.deleteTeacher(id);
	}
}
