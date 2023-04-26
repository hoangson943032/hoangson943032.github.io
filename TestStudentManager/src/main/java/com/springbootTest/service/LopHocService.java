package com.springbootTest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootTest.entities.LopHoc;
import com.springbootTest.entities.Student;




public interface LopHocService {
	
	List<LopHoc> getListClass();

	LopHoc createLopHoc(LopHoc lopHoc);

	void deleteLopHoc(Integer id);
}
