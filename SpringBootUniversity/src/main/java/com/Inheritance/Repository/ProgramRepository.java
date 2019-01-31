package com.Inheritance.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inheritance.entities.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer>{
	
	public Optional<Program> findById(Integer Program_initials);
//	public Set<Program> findAllByCoursInitials(String CoursInitials);

}
