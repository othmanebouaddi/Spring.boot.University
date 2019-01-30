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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="programs")
public class Program {
	
	
	@Id
	@Column(name="Program_initials")
	@ApiModelProperty(notes = "The initials of the  Program")
	private Integer Program_initials;
	
	@Column(name="Name")
	@ApiModelProperty(notes = "The name of Program")
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Cycle cycle;
	
	

	//Relation between Program and Cours
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(name = "program_cours",
		joinColumns = { @JoinColumn(name = "CoursInitials") },
		inverseJoinColumns = { @JoinColumn(name = "Program_initials") })
	private Set<Cours> cours = new HashSet<>();
	
	
	
	//Relation between Program and Student
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "program", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<InscriptionProgram> inscriptionPrograms = new HashSet<InscriptionProgram>();
	

	

	//Constructors
	public Program() {
	}
	
	public Program(String name, Integer Program_initials) {
		this.name = name;
		this.Program_initials = Program_initials;
	}
	
	
	//Setters and Getters
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public Integer getInitials() {
		return Program_initials;
	}

	public void setInitials(Integer Program_initials) {
		this.Program_initials = Program_initials;
	}
	
	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
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
		return Program_initials;
	}

	public void setProgram_initials(Integer program_initials) {
		Program_initials = program_initials;
	}

}
