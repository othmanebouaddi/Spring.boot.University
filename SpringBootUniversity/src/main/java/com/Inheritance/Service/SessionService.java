package com.Inheritance.service;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Season;
import com.Inheritance.entities.Session;
import com.Inheritance.repository.SessionRepository;

@Service
public class SessionService {
	
	
	@Autowired
	private SessionRepository sessionRepository;

	public Session createSession(@Valid Session session, String season) {
		if(season.equals("HIVER"))
			session.setSeason(Season.HIVER);
		else if(season.equals("AUTOMUN"))
			session.setSeason(Season.AUTOMUN);
		else if(season.equals("ETE"))
			session.setSeason(Season.ETE);
		return sessionRepository.save(session);
	}

	public List<Session> getSessions() {
		return sessionRepository.findAll();
	}
	
	

}
