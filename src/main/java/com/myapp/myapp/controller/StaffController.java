package com.myapp.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.myapp.dto.ChangeAptStatusDTO;
import com.myapp.myapp.model.Appointment;
import com.myapp.myapp.model.Staff;
import com.myapp.myapp.service.StaffService;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	StaffService staffService;

	@GetMapping(path = "/appointments")
	public List<Appointment> findStaffAppointmentListForToday(HttpServletRequest request) {
		Object obj = request.getAttribute("user");
		if (!(obj instanceof Staff))
			return null;
		Staff staff = (Staff) obj;
		try {
			return staffService.findAppointmentsForStaffForToday(staff);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping(path = "/change_appintment_status")
	public void changeStatus(HttpServletRequest request, @RequestBody ChangeAptStatusDTO changeAptStatusDTO) {
		Object obj = request.getAttribute("user");
		if (!(obj instanceof Staff))
			return;
		try {
			staffService.updateAppointment(changeAptStatusDTO.getId(), changeAptStatusDTO.getStatus());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
