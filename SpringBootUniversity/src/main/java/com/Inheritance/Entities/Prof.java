package com.Inheritance.entities;

import java.io.Serializable;
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
@Table(name="profs")
public class Prof extends Person implements Serializable{

	@Column(name="matriculProf")
	@ApiModelProperty(notes = "The Id of the Prof")
	private String matricul;
	
	@Column(name="occupation")
	@ApiModelProperty(notes = "The occupation of the Prof")
	private String occupation;
	
	@Column(name="Salary")
	@ApiModelProperty(notes = "The salary of the Prof")
	private String salary;
	
	
	@Enumerated(EnumType.ORDINAL)
	private Sex sex;
	
	//Relation bettwenn Prof and GroupCours
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "prof", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<GroupeCours> groupeCours;
	
	


	//Constructors
	public Prof(Integer personid, String name, String address, String matricul,
			String occupation, String salary) {
		super(personid, name, address);
		this.matricul = matricul;
		this.occupation = occupation;
		this.salary = salary;
	}
	
	public Prof() {
		super();
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

	public String getMatricul() {
		return matricul;
	}

	public void setMatricul(String matricul) {
		this.matricul = matricul;
	}
	
	public Set<GroupeCours> getGroupeCours() {
		return groupeCours;
	}

	public void setGroupeCours(Set<GroupeCours> groupeCours) {
		this.groupeCours = groupeCours;
	}
	
	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	

}
