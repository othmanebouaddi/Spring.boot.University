package com.Inheritance.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="sessions")
public class Session {
	
	@Id
	@Column(name="name")
	@ApiModelProperty(notes = "The name of Session")
	private String name;
	

	
	

}
