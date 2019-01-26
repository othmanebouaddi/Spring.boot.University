package com.Inheritance.repository;

import java.util.Optional; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inheritance.entities.Cours;


public interface CoursRepository extends JpaRepository<Cours, String>{
	
	public Optional<Cours> findById(String initials);
	
	

}
