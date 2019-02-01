package com.Inheritance.service;


import java.util.List;  

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Cours;
import com.Inheritance.entities.GroupeCours;
import com.Inheritance.exception.ResourceNotFoundException;
import com.Inheritance.repository.CoursRepository;
import com.Inheritance.repository.GroupeCoursRepository;

@Service
public class GroupeCoursService {
	
	@Autowired
	private GroupeCoursRepository groupeCoursRepository;
	
	@Autowired
	private CoursRepository coursRepository;


	public GroupeCours createGroupeCours(@Valid GroupeCours groupeCours, String coursInitial) {
		Cours cours = coursRepository.findByInitials(coursInitial).orElseThrow(() -> new ResourceNotFoundException("Cours", "Initial", coursInitial));
		groupeCours.setCours(cours);
		return groupeCoursRepository.save(groupeCours);
	}

	public List<GroupeCours> getAllGroupeCours() {
		return groupeCoursRepository.findAll();
	}

	
	

}
