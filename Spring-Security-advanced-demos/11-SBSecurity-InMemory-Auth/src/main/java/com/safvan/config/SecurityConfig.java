package com.safvan.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Configuring authentication with in-memory users and roles
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("sam").password("{noop}sam").authorities("ADMIN");
        auth.inMemoryAuthentication().withUser("syed").password("{noop}syed").authorities("EMPLOYEE");
        auth.inMemoryAuthentication().withUser("jai").password("{noop}jai").authorities("STUDENT");
    }

    // Configuring URL access and authorization rules
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeRequests()
                .antMatchers("/home").permitAll()  // Allow access to /home without authentication
                .antMatchers("/welcome").authenticated()  // Require authentication for /welcome
                .antMatchers("/admin").hasAnyAuthority("ADMIN")  // Requires ADMIN authority for /admin
                .antMatchers("/emp").hasAuthority("EMPLOYEE")  // Requires EMPLOYEE authority for /emp
                .antMatchers("/std").hasAuthority("STUDENT")  // Requires STUDENT authority for /std
                .anyRequest().authenticated()  // Require authentication for all other requests

            // Setting up Log-In form details
            .and()
                .formLogin()  // Enable Spring's built-in login form
                .defaultSuccessUrl("/welcome", true)  // Redirect to /welcome on successful login (alwaysUse = true)

            // Configuring Logout
            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))  // Define logout URL
                // Additional logout configurations can be added here

            // Configuring Exception Handling (optional)
            .and()
                .exceptionHandling()
                .accessDeniedPage("/denied");  // Custom access denied page
    }
}
