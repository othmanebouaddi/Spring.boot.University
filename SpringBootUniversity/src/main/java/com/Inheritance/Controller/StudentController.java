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

import com.Inheritance.entities.Student;
import com.Inheritance.service.StudentService;



@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	
	@PostMapping(value="/student/inscriptionProgram/{programId}")
    public Student inscriptionProgram(@PathVariable("programId") Integer programId, @Valid @RequestBody Student student) {
		return studentService.inscriptionProgram(student, programId);
       
    }
	
	@PutMapping(value="/student/inscriptionCours/{sudentId}/{groupeCoursId}")
    public Student inscriptionCours(@PathVariable("groupeCoursId") Integer groupeCoursId, @PathVariable("sudentId") String sudentId) {
		return studentService.inscriptionCours(sudentId, groupeCoursId);
       
    }
	
	@GetMapping(value="/student/allStudents")
    public List<Student> getStudents() {
		return studentService.getStudents();
       
    }
	
	
	
	
	
	
	
	

}
