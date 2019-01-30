package com.Inheritance.entities;

import java.util.HashSet; 
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="sessions")
public class Session {
	
	@Id
	@Column(name="session_id")
	@ApiModelProperty(notes = "The id of Session")
	private Integer id;
	
	
	@Column(name="session_name")
	@ApiModelProperty(notes = "The name of Session")
	private String name;
	
	@Enumerated(EnumType.ORDINAL)
	private Season season;
	
	
	
	//Relation between GroupCours and Session
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "session")
	private GroupeCours groupeCours;
	

	//Constructor
	public Session(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Session() {
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public GroupeCours getGroupeCours() {
		return groupeCours;
	}


	public void setGroupeCours(GroupeCours groupeCours) {
		this.groupeCours = groupeCours;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
	

}
