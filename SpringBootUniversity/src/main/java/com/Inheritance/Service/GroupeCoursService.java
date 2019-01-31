package com.Inheritance.service;


import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.GroupeCours;
import com.Inheritance.entities.Season;
import com.Inheritance.repository.GroupeCoursRepository;

@Service
public class GroupeCoursService {
	
	@Autowired
	private GroupeCoursRepository groupeCoursRepository;


	public GroupeCours createGroupeCours(@Valid GroupeCours groupeCours, String season) {
		switch(season){
		case "AUTOMUN":
			groupeCours.setSeason(Season.AUTOMUN);
			break;
		case "HIVER":
			groupeCours.setSeason(Season.HIVER);
			break;
		case "ETE":
			groupeCours.setSeason(Season.ETE);
			break;
		}
		return groupeCoursRepository.save(groupeCours);
	}

	public List<GroupeCours> getAllGroupeCours() {
		return groupeCoursRepository.findAll();
	}

	
	

}
