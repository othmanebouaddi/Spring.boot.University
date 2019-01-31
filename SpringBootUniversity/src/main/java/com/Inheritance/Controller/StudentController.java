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
	
	
	
	@PostMapping(value="/student/inscriptionProgram/{sex}")
    public Student createStudent(@PathVariable("sex") String sex, @Valid @RequestBody Student student) {
		return studentService.createStudent(student, sex);
       
    }
	
//	@PutMapping(value="/student/inscriptionCours/sudentId/{address}/{stillStudying}")
//    public Student updateStudent(@PathVariable("sudentId") String sudentId, @PathVariable("address") String address, @PathVariable("stillStudying") Boolean stillStudying) {
//		return studentService.updateStudent(sudentId, address, stillStudying);
//       
//    }
	
	
	@GetMapping(value="/student/allStudents")
    public List<Student> getStudents() {
		return studentService.getStudents();
       
    }
	
	
	
	
	
	
	
	

}
