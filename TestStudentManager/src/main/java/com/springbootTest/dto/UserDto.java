package com.springbootTest.dto;

import javax.validation.constraints.NotEmpty;



public class UserDto {

	@NotEmpty(message ="this field cannot be empty.")
	private String userName;
	
	@NotEmpty(message ="this field cannot be empty.")
	private String password;
	
	@NotEmpty(message ="this field cannot be empty.")
	private String email;
	
	@NotEmpty(message ="this field cannot be empty.")
	private String phone;
	
	@NotEmpty(message ="this field cannot be empty.")
	private String passwordConfirm;
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public UserDto(@NotEmpty(message = "this field cannot be empty.") String userName,
			@NotEmpty(message = "this field cannot be empty.") String password,
			@NotEmpty(message = "this field cannot be empty.") String email,
			@NotEmpty(message = "this field cannot be empty.") String phone,
			@NotEmpty(message = "this field cannot be empty.") String passwordConfirm) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.passwordConfirm = passwordConfirm;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
	
}
