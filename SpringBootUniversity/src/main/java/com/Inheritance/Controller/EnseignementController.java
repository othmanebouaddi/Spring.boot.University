package com.Inheritance.controller;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inheritance.entities.Enseignement;
import com.Inheritance.service.EnseignementService;

@RestController
@RequestMapping("/api")
public class EnseignementController {
	
	
	@Autowired
	EnseignementService enseignementService;
	
	@PostMapping(value="/enseignement/createEnseignement/{matriculProf}/{coursInitials}/{groupeCoursInitials}")
	public Enseignement createEnseignementGroupeCours(@Valid @RequestBody Enseignement enseignement, @PathVariable("matriculProf") String matriculProf, @PathVariable("groupeCoursInitials") String groupeCoursInitials, @PathVariable("coursInitials") String coursInitials){
		return enseignementService.createEnseignementGroupeCours(enseignement, matriculProf,groupeCoursInitials, coursInitials);
	}
	
	@GetMapping(value="/enseignement/allEnseignement")
	public List<Enseignement> getAllEnseignement(){
		return enseignementService.getAllEnseignement();
	}

}
