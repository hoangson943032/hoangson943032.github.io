package com.springbootTest.dto;

import javax.validation.constraints.NotNull;

public class LopHocDto {

	@NotNull(message ="this field cannot be empty.")
	private String className;
	
	@NotNull(message ="this field cannot be empty.")
	private Integer numberOfStudent;

	
	
	public LopHocDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LopHocDto(@NotNull(message = "this field cannot be empty.") String className,
			@NotNull(message = "this field cannot be empty.") Integer numberOfStudent) {
		super();
		this.className = className;
		this.numberOfStudent = numberOfStudent;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getNumberOfStudent() {
		return numberOfStudent;
	}

	public void setNumberOfStudent(Integer numberOfStudent) {
		this.numberOfStudent = numberOfStudent;
	}
	
	
}
