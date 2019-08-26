package com.myapp.myapp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.myapp.repository.BranchRepository;

@Component
public class SaveSampleDataOnStartup {

	@Autowired
	BranchRepository branchRepo;

	@PostConstruct
	public void saveData() {
		branchRepo.deleteAll();

	}

}
