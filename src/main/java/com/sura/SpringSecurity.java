package com.sura;



import java.util.ArrayList;
import java.util.List;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration
@EnableWebSecurity
public class SpringSecurity{
	
	@Bean
	public UserDetailsService userDetialsService() {
		
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withUsername("user")
	              .password("{noop}12345")
	              .roles("USER")
	              .build());
		
		return new InMemoryUserDetailsManager(users);
	}

}
