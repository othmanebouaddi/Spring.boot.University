package com.Inheritance.service;

import java.util.List; 

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Program;
import com.Inheritance.repository.ProgramRepository;

@Service
public class ProgramService {
	
	@Autowired
	private ProgramRepository programRepository;

	public Program createProgram(@Valid Program program) {
		return programRepository.save(program);
	}

	public List<Program> getPrograms() {
		return programRepository.findAll();
	}

}
