package com.myapp.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {

	@Id
	@GeneratedValue
	private Long id;
	String name;
	String city;
	int pincode;
	String state;

}
