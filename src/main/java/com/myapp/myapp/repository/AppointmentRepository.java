package com.myapp.myapp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.model.Appointment;
import com.myapp.myapp.model.Staff;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {

	List<Appointment> findByStaffAndDate(Staff staff, Date date);

}
