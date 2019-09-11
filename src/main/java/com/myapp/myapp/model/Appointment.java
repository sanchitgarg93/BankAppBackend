package com.myapp.myapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	String purpose;
	String subPurpose;
	@ManyToOne
	Branch branch;
	@Temporal(TemporalType.DATE)
	Date date;
	@ManyToOne(cascade = CascadeType.ALL)
	Customer customer;
	@ManyToOne
	Staff staff;
	AppointmentStatus status = AppointmentStatus.UNATTENDED;
}
