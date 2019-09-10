package com.myapp.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.myapp.myapp.model.Appointment;
import com.myapp.myapp.model.Branch;
import com.myapp.myapp.model.BranchHead;
import com.myapp.myapp.model.Customer;
import com.myapp.myapp.model.CustomerAppointmentRequest;
import com.myapp.myapp.model.Staff;
import com.myapp.myapp.repository.AppointmentRepository;
import com.myapp.myapp.service.BranchHeadService;
import com.myapp.myapp.service.BranchService;
import com.myapp.myapp.service.CustomerService;
import com.myapp.myapp.service.StaffService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
  /** The branch service. */
  @Autowired
  BranchService branchService;
  
  /** The branch head service. */
  @Autowired
  BranchHeadService branchHeadService;
  
  /** The customer service */
  @Autowired
  CustomerService customerService;
  
  /** The staff service */
  @Autowired
  StaffService staffService;
  
  /** The appointment repo. */
  @Autowired
  AppointmentRepository appointmentRepo;
  
  @Autowired
  private JavaMailSender javaMailSender;
  
  @Autowired
  RestTemplate restTemplate;
  
  private String url = "http://localhost:8080";

  /**
   * Gets the branches.
   *
   * @param city the city
   * @param state the state
   * @return the branches
   */
  @GetMapping(path="/branches")
  public List<Branch> getBranches(@RequestHeader(value="city") String city,
      @RequestHeader(value="state") String state){
    return branchService.getBranches(city, state);
  }
  
  /**
   * Save appointment.
   *
   * @param customerAppointmentRequest the customer appointment request
   * @return the appointment
   */
  @PostMapping(path="/appointments")
  public Appointment saveAppointment(@RequestBody CustomerAppointmentRequest customerAppointmentRequest) {
    System.out.println("Customer request {} : "+ customerAppointmentRequest);
    
    Branch branch = branchService.getBranch(customerAppointmentRequest.getBranchName());
    Customer customer = new Customer();
    customer.setName(customerAppointmentRequest.getName());
    customer.setPhone(customerAppointmentRequest.getPhone());
    customer.setIsHNI(Boolean.FALSE);
    Appointment appointment = new Appointment();
    appointment.setBranch(branch);
    appointment.setCustomer(customer);
    appointment.setDate(customerAppointmentRequest.getDate());
    appointment.setPurpose(customerAppointmentRequest.getPurpose());
    appointment.setSubPurpose(customerAppointmentRequest.getSubPurpose());
    
    Staff staff = staffService.findAvailableStaff();
    if (staff != null) {
      appointment.setStaff(staff);
      try {
        //appointment = appointmentRepo.save(appointment);
        //Check if Customer is HNI
        Customer hniCustomers[] = restTemplate.getForObject(url+"/hni/customers", Customer[].class);
        for(Customer hniCustomer : hniCustomers) {
          if (customer.getPhone().equals(hniCustomer.getPhone())) {
            System.out.println("High Net Worth Customer Books an appointment.");
            customer.setIsHNI(Boolean.TRUE);
            appointment = appointmentRepo.save(appointment);
            //Send notification to Branch Manager
            BranchHead branchHead = branchHeadService.getBranchHead(branch);
            System.out.println("Sending mail to branch head {} : " + branchHead.getUserName());
            sendEmail(branchHead, customer, appointment);
          }
          else
            appointment = appointmentRepo.save(appointment);
        }
      } catch (Exception e) {
        
        System.out.println("Exception {} : " + e);
      }
    }
    else {
      System.out.println("No staff available");
      return null;
    }
    return appointment;
  }
  
  public void sendEmail(BranchHead branchHead, Customer customer, Appointment appointment) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(branchHead.getUserName());
        msg.setSubject("High Net Worth Customer Visiting Your Branch");
        msg.setText("Hi "+branchHead.getName()+", \n\n"+customer.getName()
            + " is going to visit your branch on "+appointment.getDate()+" for "+appointment.getPurpose()
            + ".\n\n"
            + "Sincerely,\n"
            + "Syndicate Bank");
        javaMailSender.send(msg);
  }
}
