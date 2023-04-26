package com.springbootTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbootTest.dto.StudentDto;
import com.springbootTest.entities.LopHoc;
import com.springbootTest.service.LopHocService;


@Controller
public class StudentController {
	
	@Autowired
	LopHocService lopHocService;
	


	@RequestMapping(value = "/view-student", method = RequestMethod.GET)
	public String Student (Model model) {
		
		StudentDto studentDto = new StudentDto();
		model.addAttribute("studentDto",studentDto);
		List<LopHoc> lopHoc = lopHocService.getListClass(); 
		model.addAttribute("lopHoc", lopHoc);
		
		return "student/NewStudent";
	}
	

	@RequestMapping(value = "/view-list-student")
	public String ListStudent (Model model) {
		
		
		
		return "student/ListStudent";
	}
	
}
