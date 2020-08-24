package com.thanhnl4.unittest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhnl4.unittest.model.User;
import com.thanhnl4.unittest.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public List<User> getAll() {
		return this.userRepository.findAll();
	}
}
