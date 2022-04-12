/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.springsecuritydemo.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Класс User
 */
@Data
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Enumerated(value = EnumType.STRING)
	@Column(name = "role")
	private Role role;
	@Column(name = "status")
	@Enumerated(value = EnumType.STRING)
	private Status status;
}