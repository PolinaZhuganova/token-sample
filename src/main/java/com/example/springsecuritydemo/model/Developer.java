/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.springsecuritydemo.model;

import lombok.*;

/**
 * Класс Developer
 */
@Data
@AllArgsConstructor
public class Developer {
	private Long id;
	private String firstName;
	private String lastName;
}