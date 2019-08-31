package com.myapp.myapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import lombok.Data;

@Entity
@Inheritance
@Data
public abstract class User {

	@Id
	String userName;
	String name;
	String phone;
	String password;
	Role role;

}
