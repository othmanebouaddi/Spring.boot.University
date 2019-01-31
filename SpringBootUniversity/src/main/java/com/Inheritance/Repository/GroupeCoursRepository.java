package com.Inheritance.repository;

import java.util.Optional; 
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inheritance.entities.GroupeCours;

public interface GroupeCoursRepository extends JpaRepository<GroupeCours, Integer>{
	
	public Optional<GroupeCours> findById(Integer groupeCoursId);
//	public Set<GroupeCours> findAllByMatricul(String matricul);
//	public Set<GroupeCours> findByStudentCode(String code);

}
