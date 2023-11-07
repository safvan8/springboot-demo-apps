package com.safvan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

	@Bean
	public PasswordEncoder createPasswordEncoder() {
		// bycrypt encoder used by-default
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
