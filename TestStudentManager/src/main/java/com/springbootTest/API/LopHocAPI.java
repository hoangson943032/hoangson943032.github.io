package com.springbootTest.API;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import com.springbootTest.dto.LopHocDto;
import com.springbootTest.entities.LopHoc;
import com.springbootTest.service.LopHocService;

@RestController
public class LopHocAPI {

	@Autowired
	LopHocService lopHocService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping(value = "/class")
	public ResponseEntity<LopHocDto> createLopHoc(@Valid @RequestBody LopHocDto lopHocDto) {

		// convert DTO to entity
		LopHoc classRequest = modelMapper.map(lopHocDto, LopHoc.class);

		LopHoc lopHoc = lopHocService.createLopHoc(classRequest);

		// convert entity to DTO
		LopHocDto classResponse = modelMapper.map(lopHoc, LopHocDto.class);

		return new ResponseEntity<LopHocDto>(classResponse, HttpStatus.CREATED);
	}
	
	
	@GetMapping(value = "/class")
	public ResponseEntity<List<LopHoc>> getAllClass(){
		
		List<LopHoc> lopHoc = lopHocService.getListClass();
		
		if (lopHoc.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<LopHoc>>(lopHoc, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/class/{id}")
	public void deleteStudent(@PathVariable(value = "id") Integer id){

		lopHocService.deleteLopHoc(id);
	}
}
