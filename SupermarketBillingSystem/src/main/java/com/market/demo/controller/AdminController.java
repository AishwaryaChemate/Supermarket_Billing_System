package com.market.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.demo.entity.Customer;
import com.market.demo.entity.Order;
import com.market.demo.entity.Product;
import com.market.demo.service.CustomerService;
import com.market.demo.service.OrderService;
import com.market.demo.service.ProductService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
    OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("Customer/addCustomer")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		
		return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.CREATED);
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping("/orders")
    public List<Order> getOrders() {
        List<Order> list = orderService.getAllOrders();
        System.out.println(list.toString());
        return list;
    }
}
