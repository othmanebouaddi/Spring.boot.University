package com.Inheritance.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.GroupeCours;
import com.Inheritance.entities.Prof;
import com.Inheritance.entities.Program;
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

	public Prof createProf(@Valid Prof prof, Integer groupeCoursId) {
		Set<GroupeCours> groupeCoursList = groupeCoursRepository.findAllByProfMatricul(prof.getMatricul());
		return groupeCoursRepository.findById(groupeCoursId).map(groupeCours -> {
			groupeCoursList.add(groupeCours);
			prof.setGroupeCours(groupeCoursList);
			return profRepository.save(prof);
		}).orElseThrow(() -> new ResourceNotFoundException("Prof", "id", groupeCoursId));		
	}
}
