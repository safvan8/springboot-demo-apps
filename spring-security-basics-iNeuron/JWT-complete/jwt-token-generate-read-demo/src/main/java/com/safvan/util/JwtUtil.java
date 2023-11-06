package com.safvan.util;

import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {
	// 1. Generate JWT TOKEN
	public static String generateToken(String id, String subject, String secret) {

		// Create a JWT token with the specified claims and a secret key
		return Jwts.builder()
				.setId(id) // Set the client's ID
				.setSubject(subject) // Set the client's name
				.setIssuer("NareshIT") // Set the issuer's name
				.setIssuedAt(new Date(System.currentTimeMillis())) // Set the token generation timestamp
				// Set the token expiration time.
				.setExpiration(new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(10))) //
				// Sign the token with the secretKey using HMAC-SHA256 algorithm
				.signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode(secret.getBytes()))
				.compact(); // Convert the token to a compact form (string)
	}

	// 2. Get Claims
	public static Claims getClaims(String token, String secret) {
		// Parse the provided token and validate it using the secret key
		return Jwts.parser()
				.setSigningKey(Base64.getEncoder().encode(secret.getBytes())) // Set the secret key for verification
				.parseClaimsJws(token) // Parse and verify the token
				.getBody(); // Get the claims (payload) of the token
	}

	// Retrieve the subject (client's name) from the token
	public static String getSubject(String token, String secret) {
		return getClaims(token, secret)
				.getSubject(); // Extract and return the subject from the claims
	}

	// Check if the token is valid (not expired)
	public static boolean isValidToken(String token, String secret) {
		// Verify if the token's expiration time is after the current time
		return getClaims(token, secret)
				.getExpiration()
				.after(new Date(System.currentTimeMillis()));
	}
}
