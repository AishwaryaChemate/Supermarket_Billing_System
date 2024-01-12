package com.market.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Billing {

	@Id
	private int bId;
	@Column
	private long totalAmount;
	@Column
	private LocalDateTime billingTime;
	
	@ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;
	
	@OneToOne
	@JoinColumn(name="orderId")
	private Order order;
	
	
}
