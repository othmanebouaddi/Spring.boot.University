package com.Inheritance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inheritance.entities.Session;
import com.Inheritance.service.SessionService;

@RestController
@RequestMapping("/api")
public class SessionController {
	
	
	@Autowired
	private SessionService sessionService;
	
	
	
	@PostMapping(value="/session/createSessions")
    public Session createSession(@Valid @RequestBody Session session) {
		return sessionService.createSession(session);
       
    }
	
	@GetMapping(value="/session/allSessions")
    public List<Session> getSessions() {
		return sessionService.getSessions();
       
    }

}