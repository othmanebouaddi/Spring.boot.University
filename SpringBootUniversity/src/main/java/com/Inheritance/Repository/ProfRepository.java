package com.Inheritance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inheritance.entities.Prof;

public interface ProfRepository extends JpaRepository<Prof, String>{
	
	

}
