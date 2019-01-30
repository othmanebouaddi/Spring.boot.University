package com.Inheritance.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="cours")
public class Cours implements Serializable{
	
	@Id
	@Column(name="CoursInitials")
	@ApiModelProperty(notes = "The initials of Cours")
	private String initials;
	
	
	
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
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "cours")
	@JsonIgnore
	private Set<Program> program = new HashSet<>();


	//Constructors
	public Cours(String initials, String name, Integer credits) {
		super();
		this.initials = initials;
		this.name = name;
		this.credits = credits;
	}

	
	public Cours() {
		super();
	}




	//Setters and Getters
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
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
	
	public Set<Program> getProgram() {
		return program;
	}
	public void setProgram(Set<Program> program) {
		this.program = program;
	}
	
	
	
	
	

}
