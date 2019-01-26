package com.Inheritance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inheritance.entities.Student;

public interface StudentRepository extends JpaRepository<Student, String> {
	
	public Optional<Student> findByCode(String code);
	

}
