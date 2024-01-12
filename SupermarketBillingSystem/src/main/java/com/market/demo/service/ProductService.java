package com.market.demo.service;

import java.util.List;

import com.market.demo.entity.Product;

public interface ProductService {

	Product addProduct(Product product);

	Product getProductById(int productId);
	
	List<Product> getAllProducts();
	
	List<Product> getProductByName(String productName);

	Product updateProductDetails(Product product, int productId);

	void deleteProduct(int productId);

}
