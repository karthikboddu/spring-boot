package com.springapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springapi.entity.Product;
import com.springapi.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/addproductlist")
	public List<Product> addProductList(@RequestBody List<Product> productList){
		return productService.saveProductList(productList);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/productById/{id}")
	public Product getProductsById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/product/{name}")
	public Product getProductById(@PathVariable String name) {
		return productService.getProductByName(name);
	}
	
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping("/delete")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	
	
	
	
	
	

}
