package com.Inheritance.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Enseignement;
import com.Inheritance.entities.GroupeCours;
import com.Inheritance.entities.Prof;
import com.Inheritance.exception.ResourceNotFoundException;
import com.Inheritance.repository.EnseignementRepository;
import com.Inheritance.repository.GroupeCoursRepository;
import com.Inheritance.repository.ProfRepository;

@Service
public class EnseignementService {
	
	
	@Autowired
	private EnseignementRepository enseignementRepository;
	
	@Autowired
	private ProfRepository profRepository;
	
	@Autowired
	private GroupeCoursRepository groupeCoursRepository;


	public List<Enseignement> getAllEnseignement() {
		return enseignementRepository.findAll();
	}

	public Enseignement createEnseignementGroupeCours(@Valid Enseignement enseignement, String profId,
			Integer groupeCoursId) {
		Prof prof = profRepository.findByMatricul(profId);
		GroupeCours groupeCours = groupeCoursRepository.findById(groupeCoursId).orElseThrow(() -> new ResourceNotFoundException("GroupeCours", "id", groupeCoursId));
		enseignement.setGroupeCours(groupeCours);
		enseignement.setProf(prof);
		return enseignementRepository.save(enseignement);
	}

}
