package com.Inheritance.service;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.GroupeCours;
import com.Inheritance.entities.Session;
import com.Inheritance.exception.ResourceNotFoundException;
import com.Inheritance.repository.CoursRepository;
import com.Inheritance.repository.GroupeCoursRepository;
import com.Inheritance.repository.SessionRepository;

@Service
public class GroupeCoursService {
	
	@Autowired
	private GroupeCoursRepository groupeCoursRepository;
	
	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private CoursRepository coursRepository;

	public GroupeCours createGroupeCours(@Valid GroupeCours groupeCours, String coursId, Integer sessionId) {
		Session session = sessionRepository.findById(sessionId).orElseThrow(() -> new ResourceNotFoundException("Session", "id", sessionId));
		return coursRepository.findById(coursId).map(cours -> {
			groupeCours.setCours(cours);
			groupeCours.setSession(session);
			return groupeCoursRepository.save(groupeCours);	
		}).orElseThrow(() -> new ResourceNotFoundException("GroupeCours", "id", coursId));
	}

	public List<GroupeCours> getAllGroupeCours() {
		return groupeCoursRepository.findAll();
	}

	
	

}
