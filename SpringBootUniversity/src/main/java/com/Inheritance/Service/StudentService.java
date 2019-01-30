package com.Inheritance.service;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.GroupeCours;
import com.Inheritance.entities.Sex;
import com.Inheritance.entities.Student;
import com.Inheritance.exception.ResourceNotFoundException;
import com.Inheritance.repository.GroupeCoursRepository;
import com.Inheritance.repository.ProgramRepository;
import com.Inheritance.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ProgramRepository programRepository;
	
	@Autowired
	private GroupeCoursRepository groupeCoursRepository;

	
	public Student createStudent(@Valid Student student, String sex){
//		return programRepository.findById(Program_initials).map(program -> {
//			//student.setProgram(program);
//			if(sex.equalsIgnoreCase("M"))
//				student.setSex(Sex.M);
//			else if(sex.equalsIgnoreCase("F"))
//				student.setSex(Sex.F);
//			return studentRepository.save(student);
//		}).orElseThrow(() -> new ResourceNotFoundException("Student", "id", Program_initials));
		if(sex.equalsIgnoreCase("M"))
			student.setSex(Sex.M);
		else if(sex.equalsIgnoreCase("F"))
			student.setSex(Sex.F);
		return studentRepository.save(student);	
	}


	public List<Student> getStudents() {
		return studentRepository.findAll();
	}


//	public Student updateStudent(String sudentId) {
//		Student student = studentRepository.findByCode(sudentId).orElseThrow(() -> new ResourceNotFoundException("Student", "id", sudentId));
//		Set<GroupeCours> groupeCoursList = groupeCoursRepository.findByStudentCode(sudentId);
////		GroupeCours groupeCours = groupeCoursRepository.findById(groupeCoursId).orElseThrow(() -> new ResourceNotFoundException("Student", "id", sudentId));
////		groupeCoursList.add(groupeCours);
////		student.setGroupeCours(groupeCoursList);
//		return studentRepository.save(student);
//	
//	}

}
