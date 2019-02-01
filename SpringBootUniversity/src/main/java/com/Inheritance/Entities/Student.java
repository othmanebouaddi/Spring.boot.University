package com.Inheritance.entities;

import java.io.Serializable;  
import java.util.HashSet;  
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="student")
public class Student extends Person implements Serializable{
	
	

	@Column(name="codeStudent")
	@ApiModelProperty(notes = "The Student code")
	private String codeStudent;
	
	@Column(name="stillStudying")
	@ApiModelProperty(notes = "The Student stillStudying")
	private Boolean stillStudying;
	
	@Enumerated(EnumType.STRING)
	private Sex sex;
	
	
	//Relation between student and program
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<InscriptionProgram> inscriptionPrograms = new HashSet<InscriptionProgram>();
	
	
	
	//Relation between Student and GroupeCours
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<InscriptionGroupeCours> inscriptionGroupeCours;


	
	
	

	//Constructors
	public Student(Integer personid, String name, String address, String codeStudent,
			Boolean stillStudying) {
		super(personid, name, address);
		this.codeStudent = codeStudent;
		this.stillStudying = stillStudying;
	}

	public Student() {
		super();
	}


	//Setters and Getters
	public String getCodeStudent() {
		return codeStudent;
	}

	public void setCodeStudent(String codeStudent) {
		this.codeStudent = codeStudent;
	}
	
	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Boolean getStillStudying() {
		return stillStudying;
	}

	public void setStillStudying(Boolean stillStudying) {
		this.stillStudying = stillStudying;
	}

	public void setinscriptionPrograms(Set<InscriptionProgram> inscriptionPrograms) {
		this.inscriptionPrograms = inscriptionPrograms;
	}
	
	public Set<InscriptionProgram> getInscriptionPrograms() {
		return inscriptionPrograms;
	}
	
	public Set<InscriptionGroupeCours> getInscriptionGroupeCours() {
		return inscriptionGroupeCours;
	}

	public void setInscriptionGroupeCours(Set<InscriptionGroupeCours> inscriptionGroupeCours) {
		this.inscriptionGroupeCours = inscriptionGroupeCours;
	}
	
	
}
