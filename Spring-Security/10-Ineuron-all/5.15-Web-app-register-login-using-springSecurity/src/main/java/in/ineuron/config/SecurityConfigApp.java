package in.ineuron.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {

	@Autowired
	private UserDetailsService service;

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * this method configures Spring Security to use a custom UserDetailsService for
	 * retrieving user details during authentication and specifies the password
	 * encoder to be used for secure password storage.
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Set up authentication in Spring Security

		auth.userDetailsService(service) // Use the provided UserDetailsService to retrieve user details
				.passwordEncoder(passwordEncoder); // Set the password encoder for secure password storage
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests()
			.antMatchers("/user/register", "/user/showLogin").permitAll()
			.anyRequest().authenticated()
			
			.and().formLogin()
			.defaultSuccessUrl("/user/home",true);

		return http.build();
	}
}
