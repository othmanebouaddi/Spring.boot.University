package com.Inheritance.service;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.LettreNote;
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
			String studentId, Integer groupeCoursId) {
		Student student = studentRepository.findByCodeStudent(studentId).orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", studentId));
		inscriptionGroupeCours.setStudent(student);
		GroupeCours groupeCours = groupeCoursRepository.findById(groupeCoursId).orElseThrow(() -> new ResourceNotFoundException("GoupeCours", "groupeCoursId", groupeCoursId));
		inscriptionGroupeCours.setGroupeCours(groupeCours);
		return inscriptionGroupeCoursRepository.save(inscriptionGroupeCours);
	}

	public InscriptionGroupeCours updateinscriptionGroupeCours(@Valid InscriptionGroupeCours inscriptionGroupeCours,
			String lettreNote) {
		switch(lettreNote){
			case "A+":
				inscriptionGroupeCours.setLetterNote(LettreNote.APLUS);
				break;
			case "A":
				inscriptionGroupeCours.setLetterNote(LettreNote.A);
				break;
			case "A-":
				inscriptionGroupeCours.setLetterNote(LettreNote.AMOINS);
				break;
			case "B+":
				inscriptionGroupeCours.setLetterNote(LettreNote.BPLUS);
				break;
			case "B":
				inscriptionGroupeCours.setLetterNote(LettreNote.B);
				break;
			case "B-":
				inscriptionGroupeCours.setLetterNote(LettreNote.BMOINS);
				break;
			case "C+":
				inscriptionGroupeCours.setLetterNote(LettreNote.CPLUS);
				break;
			case "C":
				inscriptionGroupeCours.setLetterNote(LettreNote.C);
				break;
			case "C-":
				inscriptionGroupeCours.setLetterNote(LettreNote.CMOINS);
				break;
			case "D+":
				inscriptionGroupeCours.setLetterNote(LettreNote.DPLUS);
				break;
			case "D":
				inscriptionGroupeCours.setLetterNote(LettreNote.D);
				break;
			case "D-":
				inscriptionGroupeCours.setLetterNote(LettreNote.DMOINS);
				break;
			case "E":
				inscriptionGroupeCours.setLetterNote(LettreNote.E);
				break;
			
		}
		return inscriptionGroupeCoursRepository.save(inscriptionGroupeCours);
	}
	
	
	
	

}
