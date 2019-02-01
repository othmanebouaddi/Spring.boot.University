package com.Inheritance.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inheritance.entities.Cours;
import com.Inheritance.entities.GroupeCours;

public interface GroupeCoursRepository extends JpaRepository<GroupeCours, Integer>{
	
//	public GroupeCours findByInitialsAndGroupeCoursCoursInitials(String Initials, String coursInitials);
	public List<GroupeCours> findByInitials(String Initials);
//	public List<Cours> findByInitials(String Initials);


}
