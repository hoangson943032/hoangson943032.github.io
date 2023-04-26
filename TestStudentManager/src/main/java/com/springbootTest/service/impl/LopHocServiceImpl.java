package com.springbootTest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootTest.entities.LopHoc;

import com.springbootTest.repositories.LopHocRepositories;
import com.springbootTest.service.LopHocService;

@Service
public class LopHocServiceImpl implements LopHocService {

	@Autowired
	LopHocRepositories lopHocRepositories;

	@Override
	public LopHoc createLopHoc(LopHoc lopHoc) {

		return lopHocRepositories.save(lopHoc);
	}
	
	@Override
	public List<LopHoc> getListClass() {
		
		return lopHocRepositories.findAll();
	}

	@Override
	public void deleteLopHoc(Integer id) {
		LopHoc dlLopHoc = lopHocRepositories.findById(id).get();

		lopHocRepositories.delete(dlLopHoc);
	}

	

}
