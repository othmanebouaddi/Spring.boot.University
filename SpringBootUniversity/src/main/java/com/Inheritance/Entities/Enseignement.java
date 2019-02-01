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
@Table(name="enseignement")
public class Enseignement {
	
	
	
	private Integer id;
    private Prof prof;
    private GroupeCours groupeCours;
    
	
	@Column(name="NombreHeurs")
	@ApiModelProperty(notes = "NombreHeurs")
	private Double nombreHeurs;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "prof_groupecours_id")
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
    
	@ManyToOne
	@JoinColumn(name = "fk_prof", insertable = true, updatable = true)
	public Prof getProf() {
		return prof;
	}
	
	public void setProf(Prof prof) {
		this.prof = prof;
	}
	
	@ManyToOne
	@JoinColumn(name = "fk_groupecours", insertable = true, updatable = true)	
	public GroupeCours getGroupeCours() {
		return groupeCours;
	}
	
	public void setGroupeCours(GroupeCours groupeCours) {
		this.groupeCours = groupeCours;
	}

	public Double getNombreHeurs() {
		return nombreHeurs;
	}

	public void setNombreHeurs(Double nombreHeurs) {
		this.nombreHeurs = nombreHeurs;
	}

	
	
	

}
