package com.myapp.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.myapp.model.Customer;
import com.myapp.myapp.service.CustomerService;

@RestController
@RequestMapping("/hni")
public class HNIController {

	@Autowired
	CustomerService customerService;

	@GetMapping(path = "/customers")
	public List<Customer> findHNICustomers() {
		return customerService.findHNI();
	}

}
