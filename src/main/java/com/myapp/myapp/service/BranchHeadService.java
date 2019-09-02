package com.myapp.myapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.myapp.model.Appointment;
import com.myapp.myapp.model.Branch;
import com.myapp.myapp.model.BranchHead;
import com.myapp.myapp.model.Staff;
import com.myapp.myapp.repository.AppointmentRepository;
import com.myapp.myapp.repository.BranchHeadRepository;
import com.myapp.myapp.repository.StaffRepository;

@Service
public class BranchHeadService {

	@Autowired
	AppointmentRepository appointmentRepo;

	@Autowired
	StaffRepository staffRepository;
	
	@Autowired
  BranchHeadRepository branchHeadRepository;
  
  public BranchHead getBranchHead(Branch branch) {
    return branchHeadRepository.findByOwnedBranches(branch);
  }

	public List<Appointment> getAllBranchAppointmentsForToday(List<Branch> ownedBranches) {
		return appointmentRepo.findAllByBranchInAndDate(ownedBranches, new Date());
	}

	public void changeAppointmentStaff(Long appointmentId, String username) throws Exception {

		Optional<Appointment> appointmentOpt = appointmentRepo.findById(appointmentId);
		if (!appointmentOpt.isPresent())
			throw new Exception("invalid appointment id");

		Optional<Staff> staffOptional = staffRepository.findById(username);
		if (!staffOptional.isPresent())
			throw new Exception("invalid appointment id");

		Appointment appointment = appointmentOpt.get();
		Staff staff = staffOptional.get();

		appointment.setStaff(staff);
		appointmentRepo.save(appointment);

	}

}
