package com.myapp.myapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.model.Branch;
import com.myapp.myapp.model.Role;
import com.myapp.myapp.model.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, String> {

  public List<Staff> findByBranchAndRole(Branch branch, Role role);
}
