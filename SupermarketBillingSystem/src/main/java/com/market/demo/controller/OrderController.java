package com.market.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.demo.entity.Order;
import com.market.demo.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	OrderService orderservice;
	
	@GetMapping("/getAllorders")
    public List<Order> getOrders() {
        List<Order> list = orderservice.getAllOrders();
        System.out.println(list.toString());
        return list;
    }
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		
        return new ResponseEntity<Order>(orderservice.placeOrder(order), HttpStatus.CREATED);
		
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteOrder(@RequestBody Order order) {
		
		orderservice.deleteOrder(order);
		return new ResponseEntity<String>("Order deleted successfully...",HttpStatus.OK);
	}
}
