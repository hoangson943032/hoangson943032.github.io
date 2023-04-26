package com.springbootTest.API;

import java.util.List;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springbootTest.dto.StudentDto;
import com.springbootTest.entities.Student;
import com.springbootTest.repositories.LopHocRepositories;
import com.springbootTest.service.StudentService;

@RestController
public class StudentAPI {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private LopHocRepositories lopHocRepositories;
	
	@PostMapping(value = "/student")
	public ResponseEntity<StudentDto> addStudent(@Valid @RequestBody StudentDto studentDto, BindingResult bindingResult) {

		
			// convert DTO to entity
			Student studentRequest = modelMapper.map(studentDto, Student.class);
			
			Student student = studentService.createStudent(studentRequest, studentDto.getClassName());
			
			// convert entity to DTO
			StudentDto StudentResponse = modelMapper.map(student, StudentDto.class);
			
		
		return new ResponseEntity<StudentDto>(StudentResponse, HttpStatus.CREATED);
	}
	
	

	@GetMapping(value = "/student")
	public ResponseEntity<List<Student>> getListStudent(){
		
		List<Student> students = studentService.getListStudent();
		
		if (students.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	@GetMapping(value = "/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Integer id){
		
		Student student = studentService.getById(id);
		
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PutMapping(value = "/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Integer id, @Valid @RequestBody Student student, StudentDto studentDto){
		
		Student foundStudent = studentService.getById(id);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		foundStudent.setFullName(student.getFullName());
		foundStudent.setAddress(student.getAddress());
		foundStudent.setDateOfBirth(student.getDateOfBirth());
		foundStudent.setGender(student.getGender());
		foundStudent.setPhone(student.getPhone());
		
		Student updateStudent = studentService.createStudent(student, studentDto.getClassName());
		return new ResponseEntity<>(updateStudent, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/student/{id}")
	public void deleteStudent(@PathVariable(value = "id") Integer id){

		 studentService.deleteStudent(id);
	}
	
}
