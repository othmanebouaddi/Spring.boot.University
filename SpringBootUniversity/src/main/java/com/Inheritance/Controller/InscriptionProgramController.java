package com.Inheritance.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inheritance.entities.InscriptionProgram;
import com.Inheritance.entities.Prof;
import com.Inheritance.entities.Program;
import com.Inheritance.service.InscriptionProgramService;
import com.Inheritance.service.ProfService;

@RestController
@RequestMapping("/api")
public class InscriptionProgramController {
	
	
	
	@Autowired
	private InscriptionProgramService inscriptionProgramService;
	
	@PostMapping(value="/inscriptionProgram/{CodeStudent}/{Program_initials}")
    public InscriptionProgram createProf(@PathVariable("CodeStudent") String CodeStudent, @PathVariable("Program_initials") Integer Program_initials,  @Valid @RequestBody InscriptionProgram inscriptionProgram) {
		return inscriptionProgramService.inscriptionProgram(CodeStudent, Program_initials, inscriptionProgram);
       
    }
	
	
	

}
