package com.market.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.demo.entity.Customer;
import com.market.demo.service.CustomerService;

@RestController
@RequestMapping("/api/sbs")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController 
{
	@Autowired
	CustomerService custService;
	
	// http://localhost:8080/api/sbs/customers
	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		
		return new ResponseEntity<Customer>(custService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		
		return custService.getAllCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId){
		
		return new ResponseEntity<Customer>(custService.getCustomerById(customerId), HttpStatus.OK);
	}
	
	@GetMapping("/customers/byFirstname/{firstName}")
	public List<Customer> getCustomerByFirstname(@PathVariable("firstName") String firstName){
		
		return custService.getCustomerByFirstname(firstName);
	}
	
	@GetMapping("/customers/bymobileno/{mobileno}")
	public ResponseEntity<Customer> getCustomerByMobileno(@PathVariable("mobileno") long mobileno){
		
		return new ResponseEntity<Customer>(custService.getCustomerByMobileno(mobileno), HttpStatus.OK);
	}
	
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<Customer>editCustomer(@PathVariable("customerId") int customerId, @RequestBody Customer customer){
		
		return new ResponseEntity<Customer>(custService.updateCustomer(customer, customerId), HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") int customerId){
		
		custService.deleteCustomer(customerId);
		return new ResponseEntity<String>("Customer Deleted Successfully...", HttpStatus.OK);
	}
	
}