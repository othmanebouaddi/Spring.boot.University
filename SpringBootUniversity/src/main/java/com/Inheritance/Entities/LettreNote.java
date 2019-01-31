package com.Inheritance.entities;

public enum LettreNote {

	
	APLUS ("A+"),
	A ("A"),
	AMOINS ("A-"),
	BPLUS ("B+"),
	B ("B"),
	BMOINS ("B-"),
	CPLUS ("C+"),
	C ("C"),
	CMOINS ("C-"),
	DPLUS ("D+"),
	D ("D"),
	DMOINS ("D-"),
	E ("E");
	
	
	private final String name;
	
	LettreNote(String name){
		this.name = name;
	}
	
	
}
