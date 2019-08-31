package com.myapp.myapp.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.myapp.model.Appointment;
import com.myapp.myapp.service.StaffService;

//@RestController("/staff")
@RestController
public class StaffController {

	@Autowired
	StaffService staffService;

	@GetMapping(path="/appointments/{username}")
	public List<Appointment> findStaffAppointmentListForToday(@PathVariable("username") String username) {
		System.out.println("findStaffAppointmentListForToday : "+username);
		try {
			return staffService.findAppointmentsForStaffForToday(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
