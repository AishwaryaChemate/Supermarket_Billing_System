package com.market.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.demo.entity.Billing;

public interface BillRepository extends JpaRepository<Billing, Integer>{

	
}
