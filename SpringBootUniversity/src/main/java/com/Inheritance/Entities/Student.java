package com.Inheritance.Entities;

import java.util.HashSet; 
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="students")
public class Student extends Person{
	
	

	@Column(name="PermanenteCode")
	@ApiModelProperty(notes = "The database generated Student PermanenteCode")
	private String PermanenteCode;
	
	@Column(name="registrationNumber")
	@ApiModelProperty(notes = "The Student stillStudying")
	private Boolean stillStudying;
	
	
	//Relation between student and program
	@ManyToOne
	@JoinColumn(name = "Program_initials", referencedColumnName = "Program_initials")
	@JsonIgnore
	private Program program;
	
	
	
	
	

	//Relation between Student and prof
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "student")
	@JsonIgnore
	private Set<Prof> prof = new HashSet<>();
	
	
	

	//Constructors
	public Student() {
		super();
	}

	public Student(Integer personid, String name, String sex, String address, String permanenteCode,
			Boolean stillStudying) {
		super(personid, name, sex, address);
		this.PermanenteCode = permanenteCode;
		this.stillStudying = stillStudying;
	}




	//Setters and Getters
	public String getPermanenteCode() {
		return PermanenteCode;
	}

	public void setPermanenteCode(String permanenteCode) {
		PermanenteCode = permanenteCode;
	}

	public Boolean getStillStudying() {
		return stillStudying;
	}

	public void setStillStudying(Boolean stillStudying) {
		this.stillStudying = stillStudying;
	}
	
	
	public Set<Prof> getProf() {
		return prof;
	}

	public void setProf(Set<Prof> prof) {
		this.prof = prof;
	}
	
	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
	
	
}
