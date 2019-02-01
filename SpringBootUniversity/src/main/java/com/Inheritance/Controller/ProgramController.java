package com.Inheritance.controller;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inheritance.entities.Program;
import com.Inheritance.service.ProgramService;

@RestController
@RequestMapping("/api")
public class ProgramController {
		
	@Autowired
	private ProgramService programService;
	
	
	@PostMapping(value="/program/createProgram")
	public Program createProgram( @Valid @RequestBody Program program) {;
		return programService.createProgram(program);
     
	}
	
	@GetMapping(value="/program/allPrograms")
	public List<Program> getPrograms() {;
		return programService.getPrograms();
     
	}
	
	
	
	
	
}
