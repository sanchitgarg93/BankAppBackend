package com.myapp.myapp.model;

import java.util.Date;

import lombok.Data;
@Data
public class CustomerAppointmentRequest {

	private String name;
	private String phone;
	private String branchName;
	private String purpose;
	private String subPurpose;
	private Date date;
	
}
