package com.thanhnl4.unittest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thanhnl4.unittest.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	List<User> findAll();
}
