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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="students")
public class Student extends Person implements Serializable{
	
	

	@Column(name="CodeStudent")
	@ApiModelProperty(notes = "The Student code")
	private String code;
	
	@Column(name="stillStudying")
	@ApiModelProperty(notes = "The Student stillStudying")
	private Boolean stillStudying;
	
	
	//Relation between student and program
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<InscriptionProgram> inscriptionPrograms = new HashSet<InscriptionProgram>();
	
	
	
	//Relation between Student and GroupeCours
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<GroupeCours> groupeCours;

	@Enumerated(EnumType.STRING)
	private Sex sex;
	
	

	//Constructors
	public Student(Integer personid, String name, String address, String code,
			Boolean stillStudying) {
		super(personid, name, address);
		this.code = code;
		this.stillStudying = stillStudying;
	}

	public Student() {
		super();
	}


	//Setters and Getters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Set<GroupeCours> getGroupeCours() {
		return groupeCours;
	}

	public void setGroupeCours(Set<GroupeCours> groupeCours) {
		this.groupeCours = groupeCours;
	}

	public void setinscriptionPrograms(Set<InscriptionProgram> inscriptionPrograms) {
		this.inscriptionPrograms = inscriptionPrograms;
	}
	
	public Set<InscriptionProgram> getInscriptionPrograms() {
		return inscriptionPrograms;
	}
	
	
}
