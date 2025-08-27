package com.sura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sura.model.Users;
import com.sura.repo.UserRepo;

@Service
public class UserDbService {
	@Autowired
	UserRepo repo;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authManager;
	
	public Users saveUser(Users user) {//saving one user 
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return(user);
	}
	
	public List<Users> saveUsers(List<Users> users){  // saving mutiple users in list
		for(Users user : users) repo.save(user);
		return users;
	}
	
	public Optional<Users> fetchUser(int userId) { //getting a specifuc users 
		return repo.findById(userId);
	}
	
	public List<Users> fetchAllUsers(){
		return repo.findAll();			//getting all the users 
	}
	
	public Optional<Users> deleteUser(int userId) {   //deleting specific users 
		Optional<Users> deletedUser = repo.findById(userId);
		
		repo.deleteById(userId);
		return deletedUser;
		
	}
	
	public List<Users> deleteAllUsers(){
		List<Users> users = repo.findAll();		//deleting all users 
		repo.deleteAll();
		return users;
	}
	
	public String authenticate(Users user) {
		
		Authentication authenticated = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		System.out.print(user.getUsername()+" "+user.getPassword());
		if(authenticated.isAuthenticated()) return jwtService.genrateToken(user.getUsername());
		else return "powerhpuse";
	}
}
