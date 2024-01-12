package com.market.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.demo.entity.Order;
import com.market.demo.repository.OrderRepository;
import com.market.demo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository ordrepo;
	
	@Override
	public Order placeOrder(Order order) {
		if(order !=null) {
			
	          return ordrepo.save(order);
	    }
	       
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		
		return ordrepo.findAll();
	}

	@Override
	public void deleteOrder(Order order) {
		
		ordrepo.delete(order);
	}

}
