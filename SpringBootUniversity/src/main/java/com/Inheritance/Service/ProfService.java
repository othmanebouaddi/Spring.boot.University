package com.Inheritance.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.GroupeCours;
import com.Inheritance.entities.Prof;
import com.Inheritance.entities.Program;
import com.Inheritance.entities.Sex;
import com.Inheritance.exception.ResourceNotFoundException;
import com.Inheritance.repository.GroupeCoursRepository;
import com.Inheritance.repository.ProfRepository;

@Service
public class ProfService {
	
	@Autowired
	private ProfRepository profRepository;
	
	@Autowired
	private GroupeCoursRepository groupeCoursRepository;

	
	public List<Prof> getProfs() {
		return profRepository.findAll();
	}

	
	public Prof createProf(@Valid Prof prof, String sex) {
		if(sex.equalsIgnoreCase("M"))
			prof.setSex(Sex.M);
		else if(sex.equalsIgnoreCase("F"))
			prof.setSex(Sex.F);
		return profRepository.save(prof);
	}
}
