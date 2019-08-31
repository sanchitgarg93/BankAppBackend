package com.myapp.myapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.model.BranchManager;

@Repository
public interface BranchManagerRepo extends CrudRepository<BranchManager, String> {

}
