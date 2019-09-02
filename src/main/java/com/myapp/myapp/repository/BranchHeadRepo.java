package com.myapp.myapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.model.BranchHead;

@Repository
public interface BranchHeadRepo extends CrudRepository<BranchHead, String> {

}
