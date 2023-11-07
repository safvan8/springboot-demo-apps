package com.safvan.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.safvan.filter.SecurityFilter;

/**
 * Configuration class for setting up Spring Security.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private InvalidUserAuthEntryPoint authEntryPoint;

	@Autowired
	private SecurityFilter securityFilter;

	/**
	 * Configure how user authentication should be performed.
	 * 
	 * @param auth The AuthenticationManagerBuilder for configuring authentication.
	 * @throws Exception In case of configuration errors.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}

	/**
	 * Configure HTTP security rules.
	 * 
	 * @param httpSecurity The HttpSecurity object for configuring HTTP security.
	 * @throws Exception In case of configuration errors.
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.csrf().disable() // Disable Cross-Site Request Forgery (CSRF) protection
				.authorizeHttpRequests()
				.antMatchers("/user/save", "/user/login").permitAll() // Allow public access to these endpoints
				.anyRequest().authenticated() // Require authentication for all other requests

				.and()
				.exceptionHandling()
				.authenticationEntryPoint(authEntryPoint) // Handle authentication exceptions using the specified entry point

				.and()
				.sessionManagement()
				// Set the session creation policy to STATELESS to indicate stateless authentication
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)

				// Register the SecurityFilter to handle authentication for subsequent requests
				.and()
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
	}

	/**
	 * Create an AuthenticationManager bean, which is required for stateless
	 * authentication.
	 * 
	 * @return The AuthenticationManager bean.
	 * @throws Exception In case of bean creation errors.
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}
