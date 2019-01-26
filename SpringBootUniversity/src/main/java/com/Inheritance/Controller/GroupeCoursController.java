package com.Inheritance.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inheritance.entities.GroupeCours;
import com.Inheritance.service.GroupeCoursService;

@RestController
@RequestMapping("/api")
public class GroupeCoursController {
	
	
	@Autowired
	private GroupeCoursService groupeCoursService;
	
	
	@PostMapping(value="/groupeCours/createGroupeCours/{coursId}/{sessionId}")
    public GroupeCours createGroupeCours(@PathVariable("coursId") String coursId, @PathVariable("sessionId") Integer sessionId, @Valid @RequestBody GroupeCours groupeCours) {
		return groupeCoursService.createGroupeCours(groupeCours, coursId, sessionId);
       
    }
	
	@GetMapping(value="/groupeCours/allGroupeCours")
    public List<GroupeCours> getAllGroupeCours() {
		return groupeCoursService.getAllGroupeCours();
       
    }

}
