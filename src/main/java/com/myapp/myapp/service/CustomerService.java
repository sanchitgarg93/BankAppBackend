package com.myapp.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.myapp.model.Customer;
import com.myapp.myapp.repository.CustomerRepository;

@Service
public class CustomerService {

  @Autowired
  CustomerRepository customerRepository;
  
  public Customer getCustomer(String phone) {
    Customer customer =  customerRepository.findByPhone(phone);
    if (customer != null)
      return customer;
    return null;
  }
  
  public void saveCustomer(Customer customer) {
    customerRepository.save(customer);
  }
  
  public List<Customer> findHNI() {
    return (List<Customer>) customerRepository.findTop100By();
  }
}
