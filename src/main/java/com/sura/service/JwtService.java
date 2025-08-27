package com.sura.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sura.model.Users;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	private static final String SECRET = "sura_springboot_jwt_secret_key_12345678901234567890123456789012";
	public String genrateToken(String username) {
		Map<String,Object> claims = new HashMap<>();
		System.out.println("Called Jwt service");
		try {
			return Jwts.builder()
					.claims()
					.add(claims)
					.subject(username)
					.issuedAt(new Date(System.currentTimeMillis()))
					.expiration(new Date(System.currentTimeMillis() + 60*60*300))
					.and()
					.signWith(getKey())
					.compact()
					;
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return username;
	}
	
	public SecretKey getKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}
	
	public String getUsername(String jwtToken) {
		
		return genrateClaims(jwtToken,Claims::getSubject);
	}

	private <T> T genrateClaims(String jwtToken, Function<Claims,T> claimsResolver) {
		// TODO Auto-generated method stub
		final Claims claims = extractAllClaims(jwtToken);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String jwtToken) {
		// TODO Auto-generated method stub
		try {
			return Jwts.parser()
					.verifyWith(getKey())
					.build()
					.parseSignedClaims(jwtToken)
					.getPayload();
		} catch (JwtException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean validateToken(String jwtToken, UserDetails userDetials) {
		if(userDetials.getUsername().equals(getUsername(jwtToken)) && !isExpired(jwtToken)) {
			return true;
		}
		return false;
	}

	private boolean isExpired(String jwtToken) {

		return extractExpiry(jwtToken).before(new Date());
	}

	private Date extractExpiry(String jwtToken) {
		
		return genrateClaims(jwtToken,Claims ::getExpiration);
	

}
}
