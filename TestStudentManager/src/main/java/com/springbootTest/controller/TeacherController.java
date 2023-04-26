package com.springbootTest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbootTest.dto.TeacherDto;
import com.springbootTest.entities.LopHoc;
import com.springbootTest.service.LopHocService;

@Controller
public class TeacherController {

	@Autowired
	LopHocService lopHocService;
	
	@RequestMapping(value = "/view-teacher", method = RequestMethod.GET)
	public String Teacher (Model model) {
		
		TeacherDto teacherDto = new TeacherDto();
		model.addAttribute("teacherDto",teacherDto);
		List<LopHoc> lopHoc = lopHocService.getListClass(); 
		model.addAttribute("lopHoc", lopHoc);
		
		return "teacher/NewTeacher";
	}
	
	@RequestMapping(value = "/view-list-teacher")
	public String ListTeacher(Model model) {
		
		
		return "teacher/ListTeacher";
	}
}
