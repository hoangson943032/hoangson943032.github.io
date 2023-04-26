package com.springbootTest.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class StudentDto {

	
	@NotEmpty(message ="this field cannot be empty.")
	private String fullName;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@NotNull(message ="this field cannot be empty.")
	private LocalDate dateOfBirth;
	
	@NotEmpty(message ="this field cannot be empty.")
	private String phone;
	
	@NotNull(message ="this field cannot be empty.")
	private String gender;
	
	@NotEmpty(message ="this field cannot be empty.")
	private String address;
	
	@NotEmpty(message ="this field cannot be empty.")
	private String className;

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(@NotEmpty(message = "this field cannot be empty.") String fullName,
			@NotNull(message = "this field cannot be empty.") LocalDate dateOfBirth,
			@NotEmpty(message = "this field cannot be empty.") String phone,
			@NotNull(message = "this field cannot be empty.") String gender,
			@NotEmpty(message = "this field cannot be empty.") String address,
			@NotEmpty(message = "this field cannot be empty.") String className) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.gender = gender;
		this.address = address;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
	
	
}
