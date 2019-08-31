package com.myapp.myapp.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Staff extends User {
	@JsonIgnore
	@ManyToMany(mappedBy = "staff")
	List<Appointment> appointmentReservation;

}
