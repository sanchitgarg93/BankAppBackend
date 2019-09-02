package com.myapp.myapp.cotroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.myapp.dto.ChangeAppointmentStaffDto;
import com.myapp.myapp.model.Appointment;
import com.myapp.myapp.model.BranchHead;
import com.myapp.myapp.service.BranchHeadService;

@RestController
@RequestMapping("/brach_head")
public class BranchHeadController {

	@Autowired
	BranchHeadService branchHeadService;

	@GetMapping(path = "/find_branch_appointments")
	public List<Appointment> findAllBranchAppointmentForToday(HttpServletRequest request) {
		Object obj = request.getAttribute("user");
		if (!(obj instanceof BranchHead))
			return null;
		BranchHead branchHead = (BranchHead) obj;
		try {
			return branchHeadService.getAllBranchAppointmentsForToday(branchHead.getOwnedBraches());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PostMapping(path = "/reassign_staff")
	public void reassignStaff(HttpServletRequest request,
			@RequestBody ChangeAppointmentStaffDto changeAppointmentStaffDto) {
		Object obj = request.getAttribute("user");
		if (!(obj instanceof BranchHead))
			return;
		BranchHead branchHead = (BranchHead) obj;
		try {
			branchHeadService.changeAppointmentStaff(changeAppointmentStaffDto.getAppointmentId(),
					changeAppointmentStaffDto.getUsername());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

}
