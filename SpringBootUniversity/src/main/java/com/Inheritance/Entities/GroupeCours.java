package com.Inheritance.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	@JoinColumn(name = "name", referencedColumnName = "name")
	
	@JsonIgnore
	private Cours cours;
	
	
	//Relation between GroupCours and Session
	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "groupeCours")
	@JsonIgnore
	private Set<Session> sessions = new HashSet<>();
	
	
	
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
	
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	
	

}
