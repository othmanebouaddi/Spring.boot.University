package com.Inheritance.service;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inheritance.entities.Session;
import com.Inheritance.repository.SessionRepository;

@Service
public class SessionService {
	
	
	@Autowired
	private SessionRepository sessionRepository;

	public Session createSession(@Valid Session session) {
		return sessionRepository.save(session);
	}

	public List<Session> getSessions() {
		return sessionRepository.findAll();
	}
	
	

}
