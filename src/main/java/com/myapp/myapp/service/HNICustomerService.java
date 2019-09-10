package com.myapp.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.myapp.model.Customer;
import com.myapp.myapp.model.HNICustomer;
import com.myapp.myapp.repository.HNICustomerRepository;

@Service
public class HNICustomerService {

  @Autowired
  HNICustomerRepository hnicustomerRepository;
  
  public HNICustomer getCustomer(String phone) {
    HNICustomer hnicustomer =  hnicustomerRepository.findByPhone(phone);
    if (hnicustomer != null)
      return hnicustomer;
    return null;
  }
  
  public void saveHNICustomer(HNICustomer hnicustomer) {
    hnicustomerRepository.save(hnicustomer);
  }
  
  public List<HNICustomer> findTop100() {
    return (List<HNICustomer>) hnicustomerRepository.findTop100By();
  }
}
