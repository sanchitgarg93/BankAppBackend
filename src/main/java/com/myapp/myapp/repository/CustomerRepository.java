package com.myapp.myapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.myapp.myapp.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

	public Customer findByPhone(String phone);

  public List<Customer> findTop100By();
}
