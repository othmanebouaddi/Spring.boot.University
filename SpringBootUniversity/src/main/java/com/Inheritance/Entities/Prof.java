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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Profs")
public class Prof extends Person{

	@Column(name="registrationNumber")
	@ApiModelProperty(notes = "The registrationNumber of the Prof")
	private String registrationNumber;
	
	@Column(name="occupation")
	@ApiModelProperty(notes = "The occupation of the Prof")
	private String occupation;
	
	@Column(name="Salary")
	@ApiModelProperty(notes = "The salary of the Prof")
	private String salary;
	
	
	//Relation bettwenn Prof and GroupCours
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "prof", cascade = CascadeType.ALL)
    private Set<GroupeCours> groupeCours;
	
	


	//Constructors
	public Prof() {
		super();
	}
	
	public Prof(Integer personid, String name, String sex, String address, String registrationNumber,
			String occupation, String salary) {
		super(personid, name, sex, address);
		this.registrationNumber = registrationNumber;
		this.occupation = occupation;
		this.salary = salary;
	}

	//Getters and Setters
	public String getOccupation() {
		return occupation;
	}
	

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	public Set<GroupeCours> getGroupeCours() {
		return groupeCours;
	}

	public void setGroupeCours(Set<GroupeCours> groupeCours) {
		this.groupeCours = groupeCours;
	}
	
	
//	public Set<Student> getStudent() {
//		return student;
//	}
//
//	public void setStudent(Set<Student> student) {
//		this.student = student;
//	}
	
	
	

}
