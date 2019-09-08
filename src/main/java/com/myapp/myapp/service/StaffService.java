package com.myapp.myapp.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.myapp.myapp.model.Appointment;
import com.myapp.myapp.model.AppointmentStatus;
import com.myapp.myapp.model.Branch;
import com.myapp.myapp.model.Role;
import com.myapp.myapp.model.Staff;
import com.myapp.myapp.repository.AppointmentRepository;
import com.myapp.myapp.repository.StaffRepository;

@Service
public class StaffService {

  /** Is staff available. */
  private Boolean isStaffAvailable = false;

  /** Maximum number of appointments a staff can handle in a day.*/
  @Value("${maxNumberOfAppoinments}")
  private Integer maxNumberOfAppoinments;
  
	@Autowired
	AppointmentRepository apptmntRepository;
	@Autowired
	StaffRepository staffRepository;

	public List<Appointment> findAppointmentsForStaffForToday(Staff staff) throws Exception {

		Date date = new Date();
		return apptmntRepository.findByStaffAndDate(staff, date);
	}

	public void updateAppointment(Appointment appointment) {

		apptmntRepository.save(appointment);
	}

	public void updateAppointment(Long apid, AppointmentStatus status) throws Exception {
		Optional<Appointment> appointment = apptmntRepository.findById(apid);
		if (!appointment.isPresent()) {
			throw new Exception("invalid appointment id");
		}
		Appointment appointmentGet = appointment.get();
		appointmentGet.setStatus(status);
		apptmntRepository.save(appointmentGet);
	}
	
	/**
   * Find available staff.
   *
   * @return the staff
   */
  public Staff findAvailableStaff() {
    Iterable<Staff> iterableStaff = staffRepository.findAll();
    for (Staff s: iterableStaff) {
      if(apptmntRepository.countByStaffAndDate(s, new Date()) < maxNumberOfAppoinments) {
        isStaffAvailable = true;
        return s;
      }
      if (!isStaffAvailable) {
        return null;
      }
    }
    return new Staff();
  }
  
  public List<Staff> findStaffByBranch(Branch branch){
    return staffRepository.findByBranchAndRole(branch, Role.STAFF);
  }

}
