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
@Table(name = "TEACHER", schema = "dbo")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEACHER_ID", length = 36)
	private Integer teacherId;
	
	@Column(name = "FULLNAME", length = 20)
	private String fullName;
	
	@Column(name = "PHONE", length = 36)
	private String phone;
	
	@Column(name = "DATE_OF_BIRTH", length = 255)
	private LocalDate dateOfBirth;
	
	@Column(name = "POSITION", length = 255)
	private String position;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "CLASS_ID", referencedColumnName = "CLASS_ID")
	private LopHoc lopHoc;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private Users users;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(Integer teacherId, String fullName, String phone, LocalDate dateOfBirth, String position,
			LopHoc lopHoc, Users users) {
		super();
		this.teacherId = teacherId;
		this.fullName = fullName;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.position = position;
		this.lopHoc = lopHoc;
		this.users = users;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public LopHoc getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	

	
	
	
}
