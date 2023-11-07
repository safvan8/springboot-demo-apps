package com.safvan;

import java.util.Date;

import com.safvan.util.JwtUtil;

import io.jsonwebtoken.Claims;

public class Test {
	public static void main(String[] args) {
		String key = "MY-SECRET-KEY";

		// Generate a JWT token
		String token = JwtUtil.generateToken("Client-6565", "ClientName", key);
		System.out.println("Generated Token:");
		System.out.println(token);

		// Retrieve and print the claims from the token
		Claims claims = JwtUtil.getClaims(token, key);
		System.out.println("Decoded Claims:");
		System.out.println(claims);

		System.out.println("___________________________________________________________");
		String clientId = claims.getId();
		String subject = claims.getSubject();
		String issuer = claims.getIssuer();
		Date expiration = claims.getExpiration();

		System.out.println("Client ID: " + clientId);
		System.out.println("Subject: " + subject);
		System.out.println("Issuer: " + issuer);
		System.out.println("Expiration: " + expiration);

	}
}
