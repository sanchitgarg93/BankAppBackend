package com.myapp.myapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.model.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, String> {

}
