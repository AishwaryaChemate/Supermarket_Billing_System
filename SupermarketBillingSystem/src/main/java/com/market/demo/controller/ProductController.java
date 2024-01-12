package com.market.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.demo.entity.Product;
import com.market.demo.service.ProductService;

@RestController
@RequestMapping("/api/sbs")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService productService;
	
	// http://localhost:8080/api/sbs/products
	@PostMapping("products")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		
		return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.CREATED);
	}
	
	@GetMapping("/products/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId){
		
		return new ResponseEntity<Product>(productService.getProductById(productId), HttpStatus.OK);
	}
	
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product>updateProduct(@PathVariable("productId") int productId, @RequestBody Product product){
		
		return new ResponseEntity<Product>(productService.updateProductDetails(product, productId), HttpStatus.OK);
	}
	
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId){
		
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Product Deleted Successfully...", HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/getProductName/{productName}")
	public List<Product> getProductByName(@PathVariable("productName") String productName) {
		
		return productService.getProductByName(productName);
	}
}
