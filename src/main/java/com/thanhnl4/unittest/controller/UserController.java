package com.thanhnl4.unittest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thanhnl4.unittest.model.User;
import com.thanhnl4.unittest.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUser() {
		return this.userService.getAll();
	}
}
