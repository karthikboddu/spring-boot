package com.springapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springapi.entity.Product;
import com.springapi.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> saveProductList(List<Product> productList){
		return productRepo.saveAll(productList);
	}
	
	public List<Product> getProducts(){
		return productRepo.findAll();
	}
	
	public Product getProductById(int id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return productRepo.findByName(name);
	}
	
	public String deleteProduct(int id) {
		productRepo.deleteById(id);
		return "Deleted Product|| "+id;
	}
	
	public Product updateProduct(Product product) {
		 
		Product existingProduct = productRepo.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setDescription(product.getDescription());
		
		return productRepo.save(existingProduct);
	}
	
	

}
