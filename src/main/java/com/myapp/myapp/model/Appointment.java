package com.myapp.myapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private Long id;
	long phone;
	String name;
	String purpose;
	String subPurpose;
	@ManyToOne
	Branch branch;
	Date date;

}
