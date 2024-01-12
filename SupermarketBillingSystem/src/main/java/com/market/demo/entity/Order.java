package com.market.demo.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int orderId;
	
	@Column (length=15)
	private int quantity;
	
	@Column(length=10)
	private int totalAmount;
	
	@ManyToOne
    @JoinColumn(name="customerId")
    private Customer customer;
	
	@OneToOne(mappedBy = "order")
	private Billing bill;
	
	@ManyToMany(mappedBy = "order", fetch = FetchType.LAZY) 
	private List<Product> orderList=new ArrayList<>();
	
	 
}
