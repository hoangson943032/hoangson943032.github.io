package com.springbootTest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LopHocController {

	@RequestMapping(value = "/view-class")
	public String LopHoc(Model model) {
		
		
		return "class/NewClass";
	}
	
	@RequestMapping(value = "/view-list-class")
	public String ListLopHoc(Model model) {
		
		
		return "class/ListClass";
	}
	
}
