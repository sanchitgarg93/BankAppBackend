package com.myapp.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.myapp.model.Branch;
import com.myapp.myapp.repository.BranchRepository;

@Service
public class BranchService {

	@Autowired
	BranchRepository branchRepository;
	
	public List<Branch> getBranches(String city, String state) {
		List<Branch> branchList = branchRepository.findByCityAndState(city, state);
		return branchList;
	}
	
	public Branch getBranch(String branchName) {
		return branchRepository.findByName(branchName);
	}
	
	public List<Branch> getAllBranches() {
    return (List<Branch>) branchRepository.findAll();
  }
}
