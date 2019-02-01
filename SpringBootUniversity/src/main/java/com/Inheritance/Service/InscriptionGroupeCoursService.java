package com.Inheritance.service;

import java.util.List; 


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.GroupeCours;
import com.Inheritance.entities.InscriptionGroupeCours;
import com.Inheritance.entities.Student;
import com.Inheritance.exception.ResourceNotFoundException;
import com.Inheritance.repository.GroupeCoursRepository;
import com.Inheritance.repository.InscriptionGroupeCoursRepository;
import com.Inheritance.repository.StudentRepository;
 
@Service
public class InscriptionGroupeCoursService {
	
	@Autowired
	InscriptionGroupeCoursRepository  inscriptionGroupeCoursRepository;
	
	@Autowired
	GroupeCoursRepository  groupeCoursServiceRepository;
	
	@Autowired
	StudentRepository  studentRepository;
	
	@Autowired
	GroupeCoursRepository  groupeCoursRepository;

	public List<InscriptionGroupeCours> getallStudentsGroupeCours() {
		return inscriptionGroupeCoursRepository.findAll();
	}

	public InscriptionGroupeCours inscriptionGroupeCours(@Valid InscriptionGroupeCours inscriptionGroupeCours,
			String codeStudent, String groupeCoursInitials, String coursInitials) {
		Student student = studentRepository.findByCodeStudent(codeStudent).orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", codeStudent));
		inscriptionGroupeCours.setStudent(student);
		List<GroupeCours> listGroupeCours = groupeCoursRepository.findByInitials(groupeCoursInitials);
		
		for(GroupeCours groupeCours:listGroupeCours) {
	
			if(groupeCours.getCours().getInitials().equalsIgnoreCase(coursInitials)){
				inscriptionGroupeCours.setGroupeCours(groupeCours);
			}
		}
		
		return inscriptionGroupeCoursRepository.save(inscriptionGroupeCours);
	}
	
	
	
	

}
