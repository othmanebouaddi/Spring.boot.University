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

import com.Inheritance.entities.Cours;
import com.Inheritance.service.CoursService;

@RestController
@RequestMapping("/api")
public class CoursController {
	
	
	@Autowired
	private CoursService coursService;
	
	
	@PostMapping(value="/cours/createCours/{programId}")
    public Cours createCours(@PathVariable("programId") Integer programId, @Valid @RequestBody Cours cours) {
		return coursService.createCours(cours, programId);
       
    }
	
	@GetMapping(value="/cours/allCours")
    public List<Cours> getAllCours() {
		return coursService.getAllCours();
       
    }

}
