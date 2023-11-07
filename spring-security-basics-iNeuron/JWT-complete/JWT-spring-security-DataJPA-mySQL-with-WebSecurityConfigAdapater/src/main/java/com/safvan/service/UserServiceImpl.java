package com.safvan.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.safvan.model.User;
import com.safvan.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Integer saveUser(User user) {
		// Encode password
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user).getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> userOptional = userRepository.findUserByUsername(username);

		if (userOptional.isEmpty())
			throw new UsernameNotFoundException("User not existed");

		User user = userOptional.get();

		return org.springframework.security.core.userdetails.User
				.builder()
				.username(username)
				.password(user.getPassword())
				.authorities(user.getRoles().stream()
						.map(role -> new SimpleGrantedAuthority(role))
						.collect(Collectors.toList()))
				.build();
	}

}
