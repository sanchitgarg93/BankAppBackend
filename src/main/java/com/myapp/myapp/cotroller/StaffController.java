package com.myapp.myapp.cotroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
