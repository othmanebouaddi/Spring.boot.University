package com.Inheritance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Inheritance.entities.Enseignement;
import com.Inheritance.entities.GroupeCours;
import com.Inheritance.service.EnseignementService;

@RestController
public class EnseignementController {
	
	
	@Autowired
	EnseignementService enseignementService;
	
	@PostMapping(value="/enseignement/createEnseignement/{profId}/{groupeCoursId}")
	public Enseignement createEnseignementGroupeCours(@Valid @RequestBody Enseignement enseignement, @PathVariable("profId") String profId, @PathVariable("groupeCoursId") Integer groupeCoursId){
		return enseignementService.createEnseignementGroupeCours(enseignement, profId, groupeCoursId);
	}
	
	@GetMapping(value="/enseignement/allEnseignement")
	public List<Enseignement> getAllEnseignement(){
		return enseignementService.getAllEnseignement();
	}

}
