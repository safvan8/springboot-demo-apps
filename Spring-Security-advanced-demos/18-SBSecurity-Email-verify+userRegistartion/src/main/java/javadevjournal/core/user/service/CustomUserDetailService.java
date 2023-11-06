package javadevjournal.core.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javadevjournal.core.user.jpa.data.UserEntity;
import javadevjournal.core.user.jpa.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		final UserEntity customer = userRepository.findByEmail(email);
		if (customer == null) {
			throw new UsernameNotFoundException(email);
		}
		boolean enabled = !customer.isAccountVerified();
		UserDetails user = User
							.withUsername(customer.getEmail())
							.password(customer.getPassword())
							.disabled(enabled)
							.authorities("USER")
							.build();
		return user;
	}
}