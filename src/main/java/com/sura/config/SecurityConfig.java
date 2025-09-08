package com.sura.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.sura.filter.JwtFilter;

@Configuration
public class SecurityConfig {
	
	@Autowired
	JwtFilter jwtFilter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		
		return security
			   .csrf(csrf -> csrf.disable())
			   .authorizeHttpRequests(request -> request.requestMatchers("/register","/mylogin.html","/mylogin").permitAll()
					   .anyRequest().authenticated())
			   .httpBasic(form -> form.disable())
			   .formLogin(form -> form.disable())
			   .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			   .build();
			   
		
	}
	@Autowired
	UserDetailsService userDetialService ;
	
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider() ;//using datbase for authentication
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetialService);
		return provider;
	}
	
	@Bean
	AuthenticationManager authmanager(AuthenticationConfiguration config) throws Exception {
		System.out.println("called authentication manager");
		return config.getAuthenticationManager();
	}
}
