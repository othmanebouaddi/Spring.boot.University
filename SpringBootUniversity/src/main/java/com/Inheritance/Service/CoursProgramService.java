package com.Inheritance.service;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Cours;
import com.Inheritance.entities.CoursProgram;
import com.Inheritance.entities.Program;
import com.Inheritance.entities.Student;
import com.Inheritance.exception.ResourceNotFoundException;
import com.Inheritance.repository.CoursProgramRepository;
import com.Inheritance.repository.CoursRepository;
import com.Inheritance.repository.ProgramRepository;

@Service
public class CoursProgramService {
	
	private static final int ArrayList = 0;

	@Autowired
	CoursProgramRepository coursProgramRepository;
	
	@Autowired
	CoursRepository coursRepository;
	
	@Autowired
	ProgramRepository programRepository;

	public List<CoursProgram> getAllCoursPrograms() {
		return coursProgramRepository.findAll();
	}
	
	
	@SuppressWarnings("null")
	public List<CoursProgram> getAllCoursProgram( Integer fk_program) {
		List<CoursProgram>  coursProgramL = coursProgramRepository.findAll();
		
		Iterator<CoursProgram> iterator = coursProgramL.iterator();
		while(iterator.hasNext()){
			CoursProgram i =  iterator.next();
			if(!(i.getProgram().getProgram_initials().equals(fk_program))) { 
				iterator.remove();
			}
		}
		return coursProgramL;
		
	
	}

	public CoursProgram createCoursProgram(@Valid CoursProgram coursProgram, String coursId, Integer programId) {
		Cours cours = coursRepository.findById(coursId).orElseThrow(() -> new ResourceNotFoundException("Cours", "Initial", coursId));
		coursProgram.setCours(cours);
		Program program = programRepository.findById(programId).orElseThrow(() -> new ResourceNotFoundException("Program", "program_initials", programId));
		coursProgram.setProgram(program);
		return coursProgramRepository.save(coursProgram);
	}
	
	
	

}
