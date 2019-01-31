package com.Inheritance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Inheritance.entities.Enseignement;

public interface EnseignementRepository extends JpaRepository<Enseignement, Integer> {

}
