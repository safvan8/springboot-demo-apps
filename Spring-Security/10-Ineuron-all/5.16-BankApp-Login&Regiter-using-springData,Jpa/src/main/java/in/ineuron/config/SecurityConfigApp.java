package in.ineuron.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigApp {

    @Autowired
    private UserDetailsService service;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Authentication configuration
        auth.userDetailsService(service).passwordEncoder(encoder);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        // Authorization configuration
        http.authorizeHttpRequests()
                .antMatchers("/bank/").permitAll() // Allow access to the /bank/ endpoint for all users
                .antMatchers("/user/register", "/user/showLogin").permitAll() // Allow public access to user registration and login pages
                .antMatchers("/bank/offers").authenticated() // Require authentication for accessing /bank/offers
                .antMatchers("/bank/balance").hasAnyAuthority("CUSTOMER", "MANAGER") // Require "CUSTOMER" or "MANAGER" role for /bank/balance
                .antMatchers("/bank/loanApprove").hasAuthority("MANAGER") // Require "MANAGER" role for /bank/loanApprove
                .anyRequest().authenticated() // Require authentication for all other requests
                
                .and().formLogin()
                .defaultSuccessUrl("/bank/", true) // Set the default success URL to /bank/ after successful login
                .loginPage("/user/showLogin") // Specify the URL for displaying the login form (GET request)
                .loginProcessingUrl("/login") // Specify the URL for processing the login form submission (POST request)
                .failureUrl("/user/showLogin?error") // Redirect to the login page with an error message on authentication failure
                
                .and().rememberMe() // Enable "Remember Me" functionality
                
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/signout")) // Define the URL for logging out
                .logoutSuccessUrl("/user/showLogin?logout") // Redirect to the login page after successful logout
                
                .and().exceptionHandling().accessDeniedPage("/denied") // Customize the access denied page
                
                .and().sessionManagement().maximumSessions(5).maxSessionsPreventsLogin(true); // Set session management properties

        return http.build();
    }
}
