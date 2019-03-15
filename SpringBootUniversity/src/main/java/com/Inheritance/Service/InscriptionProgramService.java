package com.Inheritance.service;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.Inheritance.entities.GroupeCours;
import com.Inheritance.entities.InscriptionProgram;
import com.Inheritance.entities.Prof;
import com.Inheritance.entities.Program;
import com.Inheritance.entities.Student;
import com.Inheritance.exception.ResourceNotFoundException;
import com.Inheritance.repository.InscriptionProgramRepository;
import com.Inheritance.repository.ProgramRepository;
import com.Inheritance.repository.StudentRepository;

@Service
public class InscriptionProgramService {
	
	
	@Autowired
	private InscriptionProgramRepository inscriptionProgramRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ProgramRepository programRepository;

	public InscriptionProgram inscriptionProgram(String codeStudent, Integer program_initials, @Valid InscriptionProgram inscriptionProgram) {
		Student student = studentRepository.findByCodeStudent(codeStudent).orElseThrow(() -> new ResourceNotFoundException("Student", "code", codeStudent));
		inscriptionProgram.setStudent(student);
		Program program = programRepository.findById(program_initials).orElseThrow(() -> new ResourceNotFoundException("Program", "program_initials", program_initials));
		inscriptionProgram.setProgram(program);
		return inscriptionProgramRepository.save(inscriptionProgram);
	}

	public List<InscriptionProgram> getAllStudentProgram() {
		return inscriptionProgramRepository.findAll();
	}

	public List<InscriptionProgram> allInscriptionProgramByStudent(String codeStudent) {
		List<InscriptionProgram>  inscriptionProgram = inscriptionProgramRepository.findAll();
		 
		
		Iterator<InscriptionProgram> iterator = inscriptionProgram.iterator();
		while(iterator.hasNext()){
			InscriptionProgram i =  iterator.next();
			if(!(i.getStudent().getCodeStudent().equals(codeStudent))) {	
				iterator.remove();
			}
		}
		
		 return inscriptionProgram;
	}
	
	
	
	

}
