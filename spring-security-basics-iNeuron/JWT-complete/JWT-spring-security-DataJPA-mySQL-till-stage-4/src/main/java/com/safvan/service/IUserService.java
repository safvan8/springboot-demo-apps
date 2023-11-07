package com.safvan.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.safvan.model.User;

public interface IUserService extends UserDetailsService {

	Integer saveUser(User user);

}
