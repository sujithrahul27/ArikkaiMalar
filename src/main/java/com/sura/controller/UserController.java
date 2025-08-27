package com.sura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sura.model.Users;
import com.sura.service.UserDbService;

@RestController
public class UserController {
	@Autowired
	UserDbService dbService;
	@PostMapping("/register")
	public Users newUserRegistration(@RequestBody Users user) {
		
		dbService.saveUser(user);
		
		return user;
		
	}
	
	@PostMapping("/mylogin")
	public String authenticate(@RequestBody Users user) {
		return dbService.authenticate(user);
	}
	
}
