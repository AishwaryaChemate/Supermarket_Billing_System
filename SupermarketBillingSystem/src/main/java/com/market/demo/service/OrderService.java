package com.market.demo.service;

import java.util.List;

import com.market.demo.entity.Order;

public interface OrderService {

	public Order placeOrder(Order order);
    
    public List<Order> getAllOrders();
    
    //public Order updateOrder(Order order);
    
    public void deleteOrder(Order order);
    
    //List<Product> findProductsByCustomerId(customerId, Product product);
}
