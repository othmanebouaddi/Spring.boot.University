package com.Inheritance.Entities;

import java.util.HashSet; 
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="sessions")
public class Session {
	
	@Id
	@Column(name="session_name")
	@ApiModelProperty(notes = "The name of Session")
	private String name;
	
	
	//Relation between Session and GoupeCours
	@ManyToMany(fetch = FetchType.LAZY,
		cascade = {
				CascadeType.PERSIST,
				CascadeType.MERGE
		})
	@JoinTable(name = "groupecours_session",
		joinColumns = { @JoinColumn(name = "GroupeCoursInitials") },
		inverseJoinColumns = { @JoinColumn(name = "session_name") })
	@JsonIgnore
	private Set<GroupeCours> groupeCours = new HashSet<>();

	
	
	
	
	

	//Constructor
	public Session(String name, Set<GroupeCours> groupeCours) {
		super();
		this.name = name;
		this.groupeCours = groupeCours;
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<GroupeCours> getGroupeCours() {
		return groupeCours;
	}


	public void setGroupeCours(Set<GroupeCours> groupeCours) {
		this.groupeCours = groupeCours;
	}
	

	
	

}
