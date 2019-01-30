package com.Inheritance.service;

import java.util.List;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Cycle;
import com.Inheritance.entities.Program;
import com.Inheritance.entities.Season;
import com.Inheritance.repository.ProgramRepository;

@Service
public class ProgramService {
	
	@Autowired
	private ProgramRepository programRepository;

	public Program createProgram(@Valid Program program, Integer cycle) {
		if(cycle == 1)
			program.setCycle(Cycle.BACCALAUREAT);
		else if(cycle == 2  )
			program.setCycle(Cycle.MAITRISE);
		else if(cycle == 3)
			program.setCycle(Cycle.DOCTORAT);
		return programRepository.save(program);
	}

	public List<Program> getPrograms() {
		return programRepository.findAll();
	}

}
