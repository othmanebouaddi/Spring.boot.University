package com.Inheritance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="InscriptionGroupeCours")
public class InscriptionGroupeCours {
	
	
	private Integer id;
    private Student student;
    private GroupeCours groupeCours;
    

    @Enumerated(EnumType.STRING)
	private LettreNote letterNote;
	
	@Column(name="NoteFinal")
	@ApiModelProperty(notes = "Note Final")
	private Double noteFinal;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "student_groupecours_id")
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
	@JoinColumn(name = "fk_groupecours", insertable = true, updatable = true)	
	public GroupeCours getGroupeCours() {
		return groupeCours;
	}
	
	public void setGroupeCours(GroupeCours groupeCours) {
		this.groupeCours = groupeCours;
	}


	public LettreNote getLetterNote() {
		return letterNote;
	}

	public void setLetterNote(LettreNote letterNote) {
		this.letterNote = letterNote;
	}

	public Double getNoteFinal() {
		return noteFinal;
	}

	public void setNoteFinal(Double noteFinal) {
		this.noteFinal = noteFinal;
	}
	
	
	

}
