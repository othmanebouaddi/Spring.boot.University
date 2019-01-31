package com.Inheritance.entities;

import java.io.Serializable; 
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="cours")
public class Cours implements Serializable{
	
	@Id
	@Column(name="CoursInitials")
	@ApiModelProperty(notes = "The initials of Cours")
	private String coursInitials;
	
	
	
	@Column(name="name")
	@ApiModelProperty(notes = "The name of Cours")
	private String name;
	
	
	@Column(name="credits")
	@ApiModelProperty(notes = "The credits of Cours")
	private Integer credits;
	
	//Relation bettwenn Cours and GroupCours
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "cours", cascade = CascadeType.ALL)
    private Set<GroupeCours> groupeCours;
	
	
	//Relation bettween Cours and Program
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "cours", cascade = CascadeType.ALL)
    private Set<CoursProgram> coursPrograms = new HashSet<CoursProgram>();



	//Constructors
	public Cours(String coursInitials, String name, Integer credits) {
		super();
		this.coursInitials = coursInitials;
		this.name = name;
		this.credits = credits;
	}

	
	public Cours() {
		super();
	


	//Setters and Getters
	public String getCoursInitials() {
		return coursInitials;
	}
	public void setCoursInitials(String coursInitials) {
		this.coursInitials = coursInitials;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public Set<GroupeCours> getGroupeCours() {
		return groupeCours;
	}
	public void setGroupeCours(Set<GroupeCours> groupeCours) {
		this.groupeCours = groupeCours;
	}
	
	
	public Set<CoursProgram> getCoursPrograms() {
		return coursPrograms;
	}


	public void setCoursPrograms(Set<CoursProgram> coursPrograms) {
		this.coursPrograms = coursPrograms;
	}
	
	
	

}
