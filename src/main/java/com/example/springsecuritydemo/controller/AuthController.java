/*
 * Copyright (c) 2022 Tander, All Rights Reserved.
 */

package com.example.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Класс AuthController
 */
@Controller
@RequestMapping("/auth")
public class AuthController {

	@GetMapping("/login")
	public String getLoginPage(){
		return "login";
	}
	@GetMapping("/success")
		public String getSuccessPage(){
			return "success";
		}
	}