/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.springsecuritydemo.config;

import com.example.springsecuritydemo.model.Role;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


/**
 * Класс SecurityConfig
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers().permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/auth/login").permitAll()
			.defaultSuccessUrl("/auth/success")
			.and()
			.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
			.invalidateHttpSession(true)
			.clearAuthentication(true)
			.deleteCookies("JSESSIONID")
			.logoutSuccessUrl("/auth/login");

	}

	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		return new InMemoryUserDetailsManager(
			User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin"))
				.authorities(Role.ADMIN.getAuthorities())
				.build(),
			User.builder()
				.username("user")
				.password(passwordEncoder().encode("user"))
				.authorities(Role.USER.getAuthorities())
				.build()
		);
	}

	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);
	}

}