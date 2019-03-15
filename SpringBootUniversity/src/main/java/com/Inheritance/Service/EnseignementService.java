package com.Inheritance.service;

import java.util.Iterator;
import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Enseignement;
import com.Inheritance.entities.GroupeCours;
import com.Inheritance.entities.InscriptionGroupeCours;
import com.Inheritance.entities.Prof;
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

	public Enseignement createEnseignementGroupeCours(@Valid Enseignement enseignement, String matriculProf,
			String groupeCoursInitials, String coursInitials) {
		Prof prof = profRepository.findByMatricul(matriculProf);
		enseignement.setProf(prof);
		List<GroupeCours>  listGroupeCours =groupeCoursRepository.findByInitials(groupeCoursInitials);
		for(GroupeCours groupeCours:listGroupeCours) {
	
			if(groupeCours.getCours().getInitials().equalsIgnoreCase(coursInitials)){
				enseignement.setGroupeCours(groupeCours);
			}
		}
		return enseignementRepository.save(enseignement);
	}

	public List<Enseignement> getAllEnseignementByProf(String matricul) {
		List<Enseignement>  enseignement = enseignementRepository.findAll();
		 
		
		Iterator<Enseignement> iterator = enseignement.iterator();
		while(iterator.hasNext()){
			Enseignement i =  iterator.next();
			if(!(i.getProf().getMatricul().equals(matricul))) {
				iterator.remove();
			}
		}
		
		 return enseignement;
	}

}
