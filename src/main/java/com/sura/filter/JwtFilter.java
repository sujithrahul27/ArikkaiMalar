package com.sura.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sura.service.JwtService;
import com.sura.service.MyUserDetialsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{

	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	ApplicationContext context;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String jwtToken = null;
		String username = null;
		String authHeader = request.getHeader("Authorization");
		if(authHeader != null && authHeader.startsWith("Bearer ")) {
			jwtToken = authHeader.substring(7);
			username = jwtService.getUsername(jwtToken);
			
		}
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetials = context.getBean(MyUserDetialsService.class).loadUserByUsername(username);
			if(jwtService.validateToken(jwtToken,userDetials)) {
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetials,null,userDetials.getAuthorities());
				token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(token);
			}
			
		}
		filterChain.doFilter(request, response);
		
	}
	
	
}
