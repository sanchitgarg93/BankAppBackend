package com.myapp.myapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.myapp.model.Appointment;
import com.myapp.myapp.model.Staff;
import com.myapp.myapp.repository.AppointmentRepository;
import com.myapp.myapp.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	AppointmentRepository apptmntRepo;
	@Autowired
	StaffRepository staffRepo;

	public List<Appointment> findAppointmentsForStaffForToday(String userName) throws Exception {
		Optional<Staff> staffOption = staffRepo.findById(userName);
		
		if(!staffOption.isPresent()) {
			System.out.println("satff not found");
			return null;}
		
		Staff staff=staffOption.get();
		
		staff.setUserName(userName);
		
		Date date = new Date();
		return apptmntRepo.findByStaffAndDate(staff, date);
	}

	public void changeAppointmentStatus() {

	}

}
