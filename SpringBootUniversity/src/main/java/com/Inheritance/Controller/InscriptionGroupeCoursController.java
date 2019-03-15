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
import com.Inheritance.service.InscriptionGroupeCoursService;

@RestController
@RequestMapping("/api")
public class InscriptionGroupeCoursController {
	
	
	@Autowired
	private InscriptionGroupeCoursService inscriptionGroupeCoursService;
	
	
	@PostMapping(value="/inscriptionGroupeCours/{codeStudent}/{CoursInitial}/{groupeCoursInitial}")
	public InscriptionGroupeCours inscriptionGroupeCours(@PathVariable("codeStudent") String codeStudent, @PathVariable("CoursInitial") String CoursInitial, @PathVariable("groupeCoursInitial") String groupeCoursInitial,  @Valid @RequestBody InscriptionGroupeCours inscriptionGroupeCours) {;
		return inscriptionGroupeCoursService.inscriptionGroupeCours(inscriptionGroupeCours, codeStudent, groupeCoursInitial, CoursInitial);
     
	}
	
	@GetMapping(value="/inscriptionGroupeCours/allStudentsGroupeCours")
	public List<InscriptionGroupeCours> getallStudentsGroupeCours() {;
		return inscriptionGroupeCoursService.getallStudentsGroupeCours();
     
	}
	
	@GetMapping(value="/inscriptionGroupeCours/allInscriptionGroupeCoursByStudents/{codeStudent}")
	public List<InscriptionGroupeCours> allInscriptionGroupeCoursByStudents(@PathVariable("codeStudent") String codeStudent) {;
		return inscriptionGroupeCoursService.getAllInscriptionGroupeCoursByStudents(codeStudent);
     
	}
	

}
