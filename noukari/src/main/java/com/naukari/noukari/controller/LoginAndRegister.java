package com.naukari.noukari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naukari.noukari.model.User;
import com.naukari.noukari.service.UserService;

@RestController
public class LoginAndRegister {

	@Autowired
	private UserService service;

	@PostMapping("/login")
	public User checkUser(@RequestBody User user) {

		return service.login(user);

	}
}
