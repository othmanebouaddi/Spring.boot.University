package com.Inheritance.entities;

import java.util.HashSet; 
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="program")
public class Program {
	
	
	@Id
	@Column(name="Program_initials")
	@ApiModelProperty(notes = "The initials of the  Program")
	private Integer program_initials;
	
	@Column(name="Name")
	@ApiModelProperty(notes = "The name of Program")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Cycle cycle;
	
	

	//Relation between Program and Cours
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "program", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<CoursProgram> coursPrograms = new HashSet<CoursProgram>();
	
	

	//Relation between Program and Student
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "program", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<InscriptionProgram> inscriptionPrograms = new HashSet<InscriptionProgram>();
	

	

	//Constructors
	public Program() {
	}
	
	public Program(String name, Integer program_initials) {
		this.name = name;
		this.program_initials = program_initials;
	}
	
	
	//Setters and Getters
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	
	public Set<InscriptionProgram> getInscriptionPrograms() {
		return inscriptionPrograms;
	}

	public void setInscriptionProgram(Set<InscriptionProgram> inscriptionPrograms) {
		this.inscriptionPrograms = inscriptionPrograms;
	}
	
	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	public Integer getProgram_initials() {
		return program_initials;
	}

	public void setProgram_initials(Integer program_initials) {
		this.program_initials = program_initials;
	}
	
	public Set<CoursProgram> getCoursPrograms() {
		return coursPrograms;
	}

	public void setCoursPrograms(Set<CoursProgram> coursPrograms) {
		this.coursPrograms = coursPrograms;
	}

}
