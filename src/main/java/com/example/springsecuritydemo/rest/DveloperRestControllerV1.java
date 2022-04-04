/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.springsecuritydemo.rest;

import com.example.springsecuritydemo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.*;

/**
 * Класс DveloperRestController
 */
@RestController
@RequestMapping("/api/v1/developers")
public class DveloperRestControllerV1 {
	private List<Developer> DEVELOPERS = Stream.of(
		new Developer(1L,"Ivan", "Ivanov"),
		new Developer(2L, "Sergey", "Sergeev"),
		new Developer(3L, "Petr", "Petrov")
	).collect(Collectors.toList());


	@GetMapping
	public List<Developer> getAll() {
		return DEVELOPERS;
	}

	@GetMapping("/{id}")
	public Developer getById(@PathVariable Long id) {
		return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id))
			.findFirst()
			.orElse(null);
	}
}