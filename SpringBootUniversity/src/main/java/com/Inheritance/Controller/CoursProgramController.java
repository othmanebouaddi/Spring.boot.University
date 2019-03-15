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

import com.Inheritance.entities.CoursProgram;
import com.Inheritance.entities.GroupeCours;
import com.Inheritance.service.CoursProgramService;

@RestController
@RequestMapping("/api")
public class CoursProgramController {
	
	
	@Autowired
	CoursProgramService coursProgramService;
	
	
	@PostMapping(value="/coursProgram/createCoursProgram/{coursId}/{programId}")
    public CoursProgram createCoursProgram(@PathVariable("coursId") String coursId, @PathVariable("programId") Integer programId, @Valid @RequestBody CoursProgram coursProgram) {
		return coursProgramService.createCoursProgram(coursProgram, coursId, programId);
    }
	
	@GetMapping(value="/coursProgram/allCoursProgram")
    public List<CoursProgram> getAllCoursPrograms() {
		return coursProgramService.getAllCoursPrograms();
       
    }
	@GetMapping(value="/coursProgram/allCoursProgram/{fk_program}")
    public List<CoursProgram> getAllCoursProgram(@PathVariable("fk_program") Integer fk_program) {
		return coursProgramService.getAllCoursProgram(fk_program);
       
    }

}
