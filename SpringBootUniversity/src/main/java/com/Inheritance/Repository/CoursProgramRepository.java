package com.Inheritance.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inheritance.entities.CoursProgram;

public interface CoursProgramRepository extends JpaRepository<CoursProgram, Integer>{
	
//	public List<CoursProgram> findAllByfkProgram(Integer fk_program);

}
