package com.Inheritance.controller;

import java.util.List;  

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inheritance.entities.Prof;
import com.Inheritance.service.ProfService;

@RestController
@RequestMapping("/api")
public class ProfController {
	
	
	@Autowired
	private ProfService profService;
	
	@PostMapping(value="/prof/createProf")
    public Prof createProf(@Valid @RequestBody Prof prof) {
		return profService.createProf(prof);
       
    }
	
	@GetMapping(value="/prof/allProfs")
    public List<Prof> getProfs() {
		return profService.getProfs();
       
    }
	
	

}
