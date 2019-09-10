package com.myapp.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.myapp.model.HNICustomer;
import com.myapp.myapp.service.HNICustomerService;

@RestController
@RequestMapping("/hni")
public class HNIController {

	@Autowired
	HNICustomerService hnicustomerService;

	@GetMapping(path = "/customers")
	public List<HNICustomer> findHNICustomers() {
		return hnicustomerService.findTop100();
	}
	
	@PostMapping(path = "/customers")
  public ResponseEntity<String> saveHNICustomers(@RequestBody HNICustomer hnicustomer) {
    hnicustomerService.saveHNICustomer(hnicustomer);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
