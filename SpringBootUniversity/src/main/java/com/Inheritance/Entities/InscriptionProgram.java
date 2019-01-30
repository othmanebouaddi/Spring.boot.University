package com.Inheritance.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class InscriptionProgram implements Serializable{
	
	private Integer id;
    private Student student;
    private Program program;
    
    @Column(name="MoyenProgram")
	@ApiModelProperty(notes = "Program medium")
	private Integer moyenProgram;
	
	@Column(name="DateInscription")
	@ApiModelProperty(notes = "Inscription date")
	private String dateInscription ;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "student_program_id")
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
    
	@ManyToOne
	@JoinColumn(name = "fk_student", insertable = true, updatable = true)
	public Student getStudent() {
		return student;
	}
	
	public void setStudent(Student student) {
		this.student = student;
	}
	
	@ManyToOne
	@JoinColumn(name = "fk_program", insertable = true, updatable = true)	
	public Program getProgram() {
		return program;
	}
	
	public void setProgram(Program program) {
		this.program = program;
	}
	
	public Integer getMoyenProgram() {
		return moyenProgram;
	}
	
	public void setMoyenProgram(Integer moyenProgram) {
		this.moyenProgram = moyenProgram;
	}
	
	public String getDateInscription() {
		return dateInscription;
	}
	
	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}
	

}
