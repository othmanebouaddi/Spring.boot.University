package com.Inheritance.service;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Prof;
import com.Inheritance.repository.ProfRepository;

@Service
public class ProfService {
	
	@Autowired
	private ProfRepository profRepository;

	
	public List<Prof> getProfs() {
		return profRepository.findAll();
	}

	
	public Prof createProf(@Valid Prof prof) {
		return profRepository.save(prof);
	}
}
