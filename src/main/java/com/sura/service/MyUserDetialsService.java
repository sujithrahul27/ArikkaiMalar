package com.sura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sura.model.PrincpalUser;
import com.sura.model.Users;
import com.sura.repo.UserRepo;
@Service
public class MyUserDetialsService implements UserDetailsService {
	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = repo.findByusername(username);
		if(user == null) throw new UsernameNotFoundException("UserName not found");
		return new PrincpalUser(user);
	}

}
