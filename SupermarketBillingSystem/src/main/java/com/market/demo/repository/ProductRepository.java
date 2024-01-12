package com.market.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.market.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query("Select p from Product p where p.productName=?1")
	List<Product> findProductByName(String productName);
}
