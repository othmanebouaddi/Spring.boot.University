package com.Inheritance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inheritance.entities.Session;

public interface SessionRepository extends JpaRepository<Session, Integer>{
	
	public Optional<Session> findById(Integer session_id);

}
