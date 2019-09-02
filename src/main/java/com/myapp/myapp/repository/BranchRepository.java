package com.myapp.myapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.model.Branch;

@Repository
public interface BranchRepository extends CrudRepository<Branch, Long> {
  
  public List<Branch> findByCityAndState(String city, String state);
  
  public Branch findByName(String branchName);
}
