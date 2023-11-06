package javadevjournal.core.security;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Resource
	UserDetailsService userDetailsService;

	@Resource
	PasswordEncoder passwordEncoder;

	@Resource
	private DataSource dataSource;

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/register").permitAll()
                .antMatchers("/account/**").hasAnyAuthority("USER")
               
                .and()

                //Login configurations
                .formLogin()
                .defaultSuccessUrl("/account/home")
                .loginPage("/login")
                .failureUrl("/login?error=true");
              

    }
}
