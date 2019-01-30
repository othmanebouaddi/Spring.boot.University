package com.Inheritance.entities;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {
	
	
	@Id
	private Integer Personid;
	private String name;
	private String address;
	
	
	
	
	//Constructors
	public Person(Integer personid, String name, String address) {
		Personid = personid;
		this.name = name;
		this.address = address;
	}
	public Person() {
	}
	
	//Getters and Setters
	public Integer getPersonid() {
		return Personid;
	}
	public void setPersonid(Integer personid) {
		Personid = personid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	

}
