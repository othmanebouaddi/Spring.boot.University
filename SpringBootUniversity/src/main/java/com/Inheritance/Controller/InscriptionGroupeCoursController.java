package com.Inheritance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inheritance.entities.InscriptionGroupeCours;
import com.Inheritance.entities.LettreNote;
import com.Inheritance.entities.Program;
import com.Inheritance.repository.ProgramRepository;
import com.Inheritance.service.InscriptionGroupeCoursService;
import com.Inheritance.service.ProgramService;

@RestController
@RequestMapping("/api")
public class InscriptionGroupeCoursController {
	
	
	@Autowired
	private InscriptionGroupeCoursService inscriptionGroupeCoursService;
	
//	@Autowired
//	private ProgramRepository programRepository;
	
	@PostMapping(value="/inscriptionGroupeCours/{studentId}/{groupeCoursId}")
	public InscriptionGroupeCours inscriptionGroupeCours(@PathVariable("studentId") String studentId, @PathVariable("groupeCoursId") Integer groupeCoursId,  @Valid @RequestBody InscriptionGroupeCours inscriptionGroupeCours) {;
		return inscriptionGroupeCoursService.inscriptionGroupeCours(inscriptionGroupeCours, studentId, groupeCoursId);
     
	}
	
	@GetMapping(value="/inscriptionGroupeCours/allStudentsGroupeCours")
	public List<InscriptionGroupeCours> getallStudentsGroupeCours() {;
		return inscriptionGroupeCoursService.getallStudentsGroupeCours();
     
	}
	
	@PutMapping(value="/inscriptionGroupeCours/updateInscriptionGroupeCours/{lettreNote}")
	public InscriptionGroupeCours updateinscriptionGroupeCours(@PathVariable("lettreNote") String lettreNote, @Valid @RequestBody InscriptionGroupeCours inscriptionGroupeCours) {;
		return inscriptionGroupeCoursService.updateinscriptionGroupeCours(inscriptionGroupeCours, lettreNote);
     
	}

}
