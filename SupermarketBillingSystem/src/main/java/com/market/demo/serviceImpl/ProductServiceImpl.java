package com.market.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.demo.entity.Product;
import com.market.demo.exception.ProductIdNotFoundException;
import com.market.demo.repository.ProductRepository;
import com.market.demo.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product addProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product getProductById(int productId) {
	
		return productRepository.findById(productId).orElseThrow( ()-> new ProductIdNotFoundException("Product id is not found"));
	}

	@Override
	public Product updateProductDetails(Product product, int productId) {
		
		Product updateProduct = productRepository.findById(productId).orElseThrow( ()-> new ProductIdNotFoundException("Product id is not correct"));
		updateProduct.setProductName(product.getProductName());
		updateProduct.setProductPrice(product.getProductPrice());
		updateProduct.setStockQuantity(product.getStockQuantity());
		
		productRepository.save(updateProduct);
		
		return updateProduct;
	}

	@Override
	public void deleteProduct(int productId) {
		
		productRepository.findById(productId).orElseThrow( ()-> new ProductIdNotFoundException("Product id is not correct"));
		productRepository.deleteById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProductByName(String productName) {
		
		return productRepository.findProductByName(productName);
	}
}
