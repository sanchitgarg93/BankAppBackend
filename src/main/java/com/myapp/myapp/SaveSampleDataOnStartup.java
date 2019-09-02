package com.myapp.myapp;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.myapp.model.Appointment;
import com.myapp.myapp.model.AppointmentStatus;
import com.myapp.myapp.model.Branch;
import com.myapp.myapp.model.BranchHead;
import com.myapp.myapp.model.Customer;
import com.myapp.myapp.model.Role;
import com.myapp.myapp.model.Staff;
import com.myapp.myapp.repository.AppointmentRepository;
import com.myapp.myapp.repository.BranchHeadRepo;
import com.myapp.myapp.repository.BranchRepository;
import com.myapp.myapp.repository.StaffRepository;

@Component
public class SaveSampleDataOnStartup {

	@Autowired
	BranchRepository branchRepo;
	@Autowired
	BranchHeadRepo bmRepo;
	@Autowired
	StaffRepository staffRepo;
	@Autowired
	AppointmentRepository appointmentRepo;

	@PostConstruct
	public void saveData() {
		branchRepo.deleteAll();
		Branch br1 = new Branch(null, "RUNKUTA", "AGRA", "282007", "UTTER PRADESH");
		Branch br2 = new Branch(null, "SAKET AGRA", "AGRA", "252010", "UTTER PRADESH");
		branchRepo.save(br1);
		branchRepo.save(br2);

		// -------------------------

		BranchHead bManager = new BranchHead();
		bManager.setName("Sanchit Brach Manger");
		bManager.setUserName("sanchit@mail.com");
		bManager.setPassword("1234");
		bManager.setRole(Role.BRANCH_HEAD);
		bManager.setOwnedBraches(new ArrayList<Branch>() {
			{
				add(br1);
			}
		});
		bmRepo.save(bManager);

		// ------------------------------

		Staff staff1 = new Staff();
		staff1.setUserName("staff@mail.com");
		staff1.setName("Yusuf Staff");
		staff1.setPassword("1234");
		staff1.setRole(Role.STAFF);
		staffRepo.save(staff1);

		// --------------------------------

		Customer customer = new Customer("9876543210", "Sanchit Customer");
		Appointment appointment = new Appointment(null, "Account", "Account Creation", br1, new Date(), customer,
				staff1, AppointmentStatus.UNATTENDED);
		appointmentRepo.save(appointment);
	}

}
