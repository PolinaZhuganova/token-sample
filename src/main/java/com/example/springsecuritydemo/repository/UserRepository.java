package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Класс UserRepository
 */
public interface UserRepository extends JpaRepository <User, Long>{

	Optional<User> findByEmail (String email);
}