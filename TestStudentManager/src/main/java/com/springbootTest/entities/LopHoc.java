package com.springbootTest.entities;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "LOP_HOC", schema = "dbo")
public class LopHoc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLASS_ID")
	private Integer id;
	
	@Column(name = "CLASS_NAME")
	private String className;
	
	@Column(name = "NUMBER_OF_STUDENT")
	private Integer numberOfStudent;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "lopHoc", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Student> student;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "lopHoc", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Teacher> teacher;

	public LopHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LopHoc(Integer id, String className, List<Student> student, List<Teacher> teacher, Integer numberOfStudent) {
		super();
		this.id = id;
		this.className = className;
		this.student = student;
		this.teacher = teacher;
		this.numberOfStudent = numberOfStudent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void setTeacher(List<Teacher> teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "LopHoc [id=" + id + ", className=" + className + ", numberOfStudent=" + numberOfStudent + ", student="
				+ student + ", teacher=" + teacher + "]";
	}

	
	
	
}
