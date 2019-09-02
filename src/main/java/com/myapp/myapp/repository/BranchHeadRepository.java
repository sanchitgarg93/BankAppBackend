package com.myapp.myapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.model.Branch;
import com.myapp.myapp.model.BranchHead;

@Repository
public interface BranchHeadRepository extends CrudRepository<BranchHead, String> {

	public BranchHead findByOwnedBranches(Branch branch);

}
