package com.Inheritance.entities;

public enum Cycle {
	
	BACCALAUREAT ("BACCALAUREAT"),
	MAITRISE ("MAITRISE"),
	DOCTORAT ("DOCTORAT");
	
	private final String name;


	Cycle(String name) {
		this.name = name;
	}
	

}
