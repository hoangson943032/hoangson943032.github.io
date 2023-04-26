package com.springbootTest.entities;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;




@Entity
@Table(name = "STUDENT", schema = "dbo")
public class Student {

	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	
	@Column(name = "ADDRESS", length = 255)
	private String address;
	
	@Column(name = "FULL_NAME", length = 255)
	private String fullName;
	

	@Column(name = "DATE_OF_BIRTH")
	private LocalDate dateOfBirth;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column (name = "PHONE", length = 20)
	private String phone;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLASS_ID", referencedColumnName = "CLASS_ID")
	private LopHoc lopHoc;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Integer studentId, String address, String fullName, LocalDate dateOfBirth, String gender,
			String phone, LopHoc lopHoc) {
		super();
		this.studentId = studentId;
		this.address = address;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.lopHoc = lopHoc;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LopHoc getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}
	
	
}
