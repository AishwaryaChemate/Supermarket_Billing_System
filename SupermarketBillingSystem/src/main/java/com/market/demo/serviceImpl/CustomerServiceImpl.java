package com.market.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.demo.entity.Customer;
import com.market.demo.exception.CustomerIdNotFoundException;
import com.market.demo.repository.CustomerRepository;
import com.market.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer addCustomer(Customer customer) {

		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
	
		return customerRepository.findById(customerId).orElseThrow( ()-> new CustomerIdNotFoundException("Customer id is not found"));
	}

	@Override
	public Customer updateCustomer(Customer customer, int customerId) {
		
		Customer updateCustomer = customerRepository.findById(customerId).orElseThrow( ()-> new CustomerIdNotFoundException("Customer id is not correct"));
		updateCustomer.setFirstName(customer.getFirstName());
		updateCustomer.setLastName(customer.getLastName());
		updateCustomer.setMobileno(customer.getMobileno());
		updateCustomer.setEmailId(customer.getEmailId());
		
		customerRepository.save(updateCustomer);
		
		return updateCustomer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		
		customerRepository.findById(customerId).orElseThrow( ()-> new CustomerIdNotFoundException("Customer id is not correct"));
		customerRepository.deleteById(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll();
	}
	
	@Override
	public List<Customer> getCustomerByFirstname(String firstName) {
		
		return customerRepository.findCustomerByFirstname(firstName);
	}

	@Override
	public Customer getCustomerByMobileno(long mobileno) {
		
		return customerRepository.findCustomerByMobileno(mobileno);
	}
	
}
