package com.Inheritance.service;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Student;
import com.Inheritance.exception.ResourceNotFoundException;
import com.Inheritance.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	
	public Student createStudent(@Valid Student student){
		return studentRepository.save(student);	
	}


	public List<Student> getStudents() {
		return studentRepository.findAll();
	}


	public Student updateStudent(String codeStudent, Boolean stillStudying) {
		Student student = studentRepository.findByCodeStudent(codeStudent).orElseThrow(() -> new ResourceNotFoundException("Student", "id", codeStudent));
		student.setStillStudying(stillStudying);
		return studentRepository.save(student);
	}


}
