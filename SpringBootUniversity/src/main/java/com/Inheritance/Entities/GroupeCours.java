package com.Inheritance.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="groupeCours")
public class GroupeCours {
	
	@Id
	@Column(name="GroupeCoursInitials")
	@ApiModelProperty(notes = "The initials of GroupeCours")
	private String initials;

	@ManyToOne
	@JoinColumn(name = "CoursInitials", referencedColumnName = "CoursInitials")
	
	@JsonIgnore
	private Cours cours;
	
	
	//Constructors
	public GroupeCours(String initials, Cours cours) {
		super();
		this.initials = initials;
		this.cours = cours;
	}
	public GroupeCours() {
	}
	
	
	//Setters and Getters
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
	
	
	

}
