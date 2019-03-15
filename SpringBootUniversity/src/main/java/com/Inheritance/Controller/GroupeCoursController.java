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
	
	
	@PostMapping(value="/groupeCours/createGroupeCours/{coursInitial}")
    public GroupeCours createGroupeCours(@Valid @RequestBody GroupeCours groupeCours, @PathVariable("coursInitial") String coursInitial) {
		return groupeCoursService.createGroupeCours(groupeCours, coursInitial);
       
    }
	
	@GetMapping(value="/groupeCours/allGroupeCours")
    public List<GroupeCours> getAllGroupeCours() {
		return groupeCoursService.getAllGroupeCours();
       
    }
	
	@GetMapping(value="/groupeCours/allGroupeCoursBycours/{initials}")
    public List<GroupeCours> getAllGroupeCoursBycours(@PathVariable("initials") String initials) {
		return groupeCoursService.getAllGroupeCoursBycours(initials);
       
    }

}
