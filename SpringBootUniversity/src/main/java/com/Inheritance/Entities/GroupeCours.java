package com.Inheritance.entities;

import java.io.Serializable;  

import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	private Integer GroupeCoursId;
	
	@Column(name="GroupeCoursInitials")
	@ApiModelProperty(notes = "The initials of GroupeCours")
	private String initials;

	
	//Relation between GroupCours and Course
	@ManyToOne
	@JoinColumn(name = "name", referencedColumnName = "name")
	@JsonIgnore
	private Cours cours;
	
	
	//Relation between GroupCours and Prof
	@ManyToOne
	@JoinColumn(name = "matricul", referencedColumnName = "matricul")
	@JsonIgnore
	private Prof prof;
	
	
	
	//Relation between GroupCours and Session
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "groupeCours")
	@JsonIgnore
    private Session session;
	

	//Relation between GroupCours and Student
	@ManyToOne
	@JoinColumn(name = "code", referencedColumnName = "code")
	@JsonIgnore
	private Student student;
	

	
	
	
	//Constructors
	public GroupeCours(Integer GroupeCoursId, String initials) {
		super();
		this.GroupeCoursId = GroupeCoursId;
		this.initials = initials;
	}
	
	public GroupeCours() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Setters and Getters
	public Integer getGroupeCoursId() {
		return GroupeCoursId;
	}
	public void setGroupeCoursId(Integer groupeCoursId) {
		GroupeCoursId = groupeCoursId;
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
	
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudents(Student student) {
		this.student = student;
	}
	
	public Prof getProf() {
		return prof;
	}
	public void setProf(Prof prof) {
		this.prof = prof;
	}

}
