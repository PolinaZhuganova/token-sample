/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.springsecuritydemo.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Класс SecurityConfig
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
			User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build()
		);
	}

	@Bean
	protected PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(12);
	}

}