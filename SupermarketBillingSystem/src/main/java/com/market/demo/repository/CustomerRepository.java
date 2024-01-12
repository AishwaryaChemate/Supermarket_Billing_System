package com.market.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.market.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("Select c from Customer c where c.firstName=?1")
	List<Customer> findCustomerByFirstname(String firstname);
	
	@Query("Select c from Customer c where c.mobileno=?1")
	Customer findCustomerByMobileno(long mobileno);
}
