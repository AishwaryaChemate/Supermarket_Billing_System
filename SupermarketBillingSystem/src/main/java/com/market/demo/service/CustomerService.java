package com.market.demo.service;

import java.util.List;

import com.market.demo.entity.Customer;

public interface CustomerService {

	public Customer addCustomer(Customer customer);
	
	List<Customer> getAllCustomers();

	Customer getCustomerById(int customerId);

	Customer updateCustomer(Customer customer, int customerId);

	void deleteCustomer(int customerId);
	
	List<Customer> getCustomerByFirstname(String customerName);
	
	Customer getCustomerByMobileno(long mobileno);
}