package com.Inheritance.entities;

import java.io.Serializable;  
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings("serial")
@Entity
@Table(name="groupeCours")
public class GroupeCours implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GroupeCoursId")
	@ApiModelProperty(notes = "The Id of GroupeCours")
	private Integer groupeCoursId;
	
	@Column(name="Initials")
	@ApiModelProperty(notes = "The initials of GroupeCours")
	private String initials;
	
	@Column(name="Year")
	@ApiModelProperty(notes = "The year of GroupeCours")
	private Integer year;


	@Enumerated(EnumType.STRING)
	private Season season;

	
	//Relation between GroupCours and Course
	@ManyToOne
	@JoinColumn(name = "CoursInitials", referencedColumnName = "CoursInitials")
	@JsonIgnore
	private Cours cours;
	
	
	//Relation between GroupCours and Prof
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "groupeCours", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Enseignement> enseignements;


	//Relation between GroupCours and Student
	@OneToMany( fetch = FetchType.LAZY, mappedBy = "groupeCours", cascade = CascadeType.ALL)
	@JsonIgnore
    private Set<InscriptionGroupeCours> inscriptionGroupeCours;
	

	//Constructors
	public GroupeCours(Integer groupeCoursId, String initials, Integer year) {
		super();
		this.year = year; 
		this.groupeCoursId = groupeCoursId;
		this.initials = initials;
	}
	
	public GroupeCours() {
		super();
	}
	
	//Setters and Getters
	public Integer getGroupeCoursId() {
		return groupeCoursId;
	}
	public void setGroupeCoursId(Integer groupeCoursId) {
		this.groupeCoursId = groupeCoursId;
	}
	
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
	
	public Set<InscriptionGroupeCours> getInscriptionGroupeCours() {
		return inscriptionGroupeCours;
	}

	public void setInscriptionGroupeCours(Set<InscriptionGroupeCours> inscriptionGroupeCours) {
		this.inscriptionGroupeCours = inscriptionGroupeCours;
	}

	public Set<Enseignement> getEnseignements() {
		return enseignements;
	}

	public void setEnseignements(Set<Enseignement> enseignements) {
		this.enseignements = enseignements;
	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}
	
	
}
