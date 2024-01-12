package com.market.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.market.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	/*
	 * @Query(value ="SELECT * FROM Order where CustomerID =?1", nativeQuery= true)
	 * public List<Order> getByCustomerID(@Param("customerId") int id);
	 * 
	 * @Query(value ="DELETE FROM Order WHERE id= :CustomerId", nativeQuery= true)
	 *public void deleteByCustomerID(@Param("customerId") int id);
	 */
}
