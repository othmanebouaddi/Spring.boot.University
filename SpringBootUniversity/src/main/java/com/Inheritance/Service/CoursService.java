package com.Inheritance.service;


import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Cours;
import com.Inheritance.entities.Program;
import com.Inheritance.exception.ResourceNotFoundException;
import com.Inheritance.repository.CoursRepository;
import com.Inheritance.repository.ProgramRepository;


@Service
public class CoursService {
	
	@Autowired
	private CoursRepository coursRepository;
	
	@Autowired
	private ProgramRepository programRepository;

	public Cours createCours(@Valid Cours cours) {
//		Set<Program> programList = programRepository.findAllByCoursInitials(cours.getInitials());
//		return programRepository.findById(Program_initials).map(program -> {
//			programList.add(program);
//			cours.setProgram(programList);
//			return coursRepository.save(cours);	
//		}).orElseThrow(() -> new ResourceNotFoundException("Cours", "id", Program_initials));
		return coursRepository.save(cours);
		
	}

	public List<Cours> getAllCours() {
		return coursRepository.findAll();
	}
	
	
	
	

}
