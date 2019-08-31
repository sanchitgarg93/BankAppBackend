package com.myapp.myapp.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@Id
	@GeneratedValue
	private Long id;
	String purpose;
	String subPurpose;
	@ManyToOne
	Branch branch;
	@Temporal(TemporalType.DATE)
	Date date;
	@ManyToOne(cascade = CascadeType.PERSIST)
	Customer customer;
	@ManyToMany
	@JoinTable(name = "staff_customer_appointment", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "userName") })
	List<Staff> staff;
	AppointmentStatus status = AppointmentStatus.UNATTENDED;
}
