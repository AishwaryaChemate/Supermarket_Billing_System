package com.market.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Entity
public class Product {

	@Id
	private int productId;
	
	@Column (length=50, nullable = false)
	@NotBlank(message= "Product Name cannot be blank")
	private String productName;
	
	@Column (length=100, nullable = false)
	private double productPrice;
	
	@Column (length=50)
	private long stockQuantity;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="Order_Product",joinColumns=@JoinColumn(name="productId"),
	inverseJoinColumns =@JoinColumn(name="orderId")) 
	private List<Order> order=new ArrayList<>();
	
	
	
	
}
