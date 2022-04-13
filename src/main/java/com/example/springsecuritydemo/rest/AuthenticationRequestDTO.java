/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.springsecuritydemo.rest;

import lombok.Data;

/**
 * Класс AuthenticationRequestDTO
 */
@Data
public class AuthenticationRequestDTO {
	private String email;
	private String password;
}