package com.safvan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.safvan.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findUserByUsername(String username);
}
