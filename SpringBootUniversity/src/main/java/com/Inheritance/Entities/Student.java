package com.Inheritance.entities;

import java.io.Serializable;
import java.util.HashSet;  
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
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
	
	

	@Column(name="code")
	@ApiModelProperty(notes = "The Student code")
	private String code;
	
	@Column(name="stillStudying")
	@ApiModelProperty(notes = "The Student stillStudying")
	private Boolean stillStudying;
	
	
	//Relation between student and program
	@ManyToOne
	@JoinColumn(name = "Program_initials", referencedColumnName = "Program_initials")
	@JsonIgnore
	private Program program;
	
	
	//Relation between Student and GroupeCours
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<GroupeCours> groupeCours;

	
	
	

	//Constructors
	public Student(Integer personid, String name, String sex, String address, String code,
			Boolean stillStudying) {
		super(personid, name, sex, address);
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

	public Boolean getStillStudying() {
		return stillStudying;
	}

	public void setStillStudying(Boolean stillStudying) {
		this.stillStudying = stillStudying;
	}
	
	
	public Program getProgram() {
		return program;
	}

	public Set<GroupeCours> getGroupeCours() {
		return groupeCours;
	}

	public void setGroupeCours(Set<GroupeCours> groupeCours) {
		this.groupeCours = groupeCours;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
	
	
}
