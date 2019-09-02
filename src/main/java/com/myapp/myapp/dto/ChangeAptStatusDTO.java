package com.myapp.myapp.dto;

import com.myapp.myapp.model.AppointmentStatus;

import lombok.Data;

@Data
public class ChangeAptStatusDTO {
	private Long id;
	private AppointmentStatus status;

}
