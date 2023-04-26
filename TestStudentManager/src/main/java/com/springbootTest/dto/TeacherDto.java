package com.springbootTest.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class TeacherDto {

	@NotEmpty(message ="this field cannot be empty.")
	private String fullName;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@NotNull(message ="this field cannot be empty.")
	private LocalDate dateOfBirth;
	
	@NotEmpty(message ="this field cannot be empty.")
	private String phone;
	
	@NotEmpty(message ="this field cannot be empty.")
	private String position;
	
	@NotEmpty(message ="this field cannot be empty.")
	private String className;

	public TeacherDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherDto(@NotEmpty(message = "this field cannot be empty.") String fullName,
			@NotNull(message = "this field cannot be empty.") LocalDate dateOfBirth,
			@NotEmpty(message = "this field cannot be empty.") String phone,
			@NotEmpty(message = "this field cannot be empty.") String position,
			@NotEmpty(message = "this field cannot be empty.") String className) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.position = position;
		this.className = className;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	

	
	
}
