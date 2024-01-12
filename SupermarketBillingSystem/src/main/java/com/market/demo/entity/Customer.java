package com.market.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int customerId;
	
	@Column (length=25, nullable = false)
	@NotBlank(message= "Customer First name cannot be blank")
	private String firstName;
	
	@Column (length=25, nullable = false)
	@NotBlank(message= "Customer Last name cannot be blank")
	private String lastName;
		
	@Column (length=11, nullable = false, unique = true)
	@NotNull(message= "Customer's Phone number cannot be null")
	private long mobileno;
	
	@Column (length=25, nullable = false)
	@NotBlank(message= "Customer's Email cannot be blank")
	private String emailId;
	
	@OneToMany(mappedBy = "customer")
	private List<Order> orderList;
	
	@OneToMany(mappedBy = "customer")
	private List<Billing> billList;
	

}
