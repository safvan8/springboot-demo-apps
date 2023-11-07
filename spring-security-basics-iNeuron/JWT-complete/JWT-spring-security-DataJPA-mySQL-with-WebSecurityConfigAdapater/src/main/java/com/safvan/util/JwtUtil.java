package com.safvan.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${myapp.secret}")
	private String secretKey;

	// 1: Generate Token
	public String generateToken(String subject) {
		return Jwts.builder()
				.setSubject(subject)
				.setIssuer("My-company-pvt-ltd")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10)))
				.signWith(SignatureAlgorithm.HS384, secretKey.getBytes())
				.compact();
	}

	// 2: Read claims
	public Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secretKey.getBytes())
				.parseClaimsJws(token)
				.getBody();
	}

	// 3 : Read exp date.
	public Date getExpDate(String token) {
		return getClaims(token).getExpiration();
	}

	// 4 : Read subject/username
	public String getUsername(String token) {
		return getClaims(token).getSubject();
	}

	// 5 : Validate Exp date
	public boolean isTokenExpired(String token) {
		Date expDate = getExpDate(token);
		return expDate.before(new Date(System.currentTimeMillis()));
	}

	// 6 : Validate token, check username with username in DB, check token expired
	public boolean isTokenValid(String token, String usernameFromDb) {
		String tokenUsername = getUsername(token);
		return usernameFromDb.equals(tokenUsername) && !isTokenExpired(token);
	}
}
