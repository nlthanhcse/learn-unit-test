package com.thanhnl4.unittest.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private Integer id;
	private Integer age;
	private String name;
}
