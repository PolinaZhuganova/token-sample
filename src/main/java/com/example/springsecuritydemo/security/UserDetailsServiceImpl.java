/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.springsecuritydemo.security;

import com.example.springsecuritydemo.model.User;
import com.example.springsecuritydemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

/**
 * Класс UserDetailsServiceImpl
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository userRepository;

	@Autowired
	public UserDetailsServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email).orElseThrow(()->
			new UsernameNotFoundException("User doesn't exist"));
		return SecurityUser.fromUser(user);
	}
}