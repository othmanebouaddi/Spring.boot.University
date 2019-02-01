package com.Inheritance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="CoursProgram")
public class CoursProgram {
	
	
	private Integer id;
    private Cours cours;
    private Program program;
    
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "program_cours_id")
    public Integer getId() {
        return id;
    }
    
    @Column(name="Optional")
	@ApiModelProperty(notes = "Optional course")
	private Boolean optional;
    
	
 
    public void setId(Integer id) {
        this.id = id;
    }
    
	@ManyToOne
	@JoinColumn(name = "fk_cours", insertable = true, updatable = true)
	public Cours getCours() {
		return cours;
	}
	
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
	@ManyToOne
	@JoinColumn(name = "fk_program", insertable = true, updatable = true)	
	public Program getProgram() {
		return program;
	}
	
	public void setProgram(Program program) {
		this.program = program;
	}

	public Boolean getOptional() {
		return optional;
	}

	public void setOptional(Boolean optional) {
		this.optional = optional;
	}
	
	

}
