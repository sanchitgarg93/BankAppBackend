package com.myapp.myapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	String userName;
	String name;
	String phone;
	String password;
	Role role;

}
