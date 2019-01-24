package com.Inheritance.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String initials;
	
	@Column(name="name")
	@ApiModelProperty(notes = "The name of Program")
	private String name;
	
	//Relation between Program and Cours
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
		@JoinTable(name = "program_cours",
			joinColumns = { @JoinColumn(name = "CoursInitials") },
			inverseJoinColumns = { @JoinColumn(name = "Program_initials") })
		@JsonIgnore
		private Set<Cours> cours = new HashSet<>();
	
	//Relation between Program and Student
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "program", cascade = CascadeType.ALL)
    private Set<Student> student;
	

	

	//Constructors
	public Program() {
	}
	
	public Program(String name, String initials) {
		this.name = name;
		this.initials = initials;
	}
	
	
	//Setters and Getters
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials;
	}
	
	public Set<Cours> getCours() {
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}
	public Set<Student> getStudent() {
		return student;
	}

	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	

}
