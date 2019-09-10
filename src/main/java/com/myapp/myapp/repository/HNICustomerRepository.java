package com.myapp.myapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.model.HNICustomer;

@Repository
public interface HNICustomerRepository extends CrudRepository<HNICustomer, String> {

	public HNICustomer findByPhone(String phone);

  public List<HNICustomer> findTop100By();
}
