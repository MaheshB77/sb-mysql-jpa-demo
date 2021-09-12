package com.mahesh.sbmysqljpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.sbmysqljpademo.entity.Product;
import com.mahesh.sbmysqljpademo.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save/")
	public Object save(@RequestBody Product product) {
		return productService.save(product);
	}
	
	@PostMapping("/save-all/")
	public Object saveAll(@RequestBody List<Product> products) {
		return productService.saveAll(products);
	}
	
	@GetMapping("/get/{id}/")
	public Object getById(@PathVariable("id") Integer id) {
		if(productService.getById(id) != null) {
			return productService.getById(id);
		} else {
			return "Product not present";
		}
	}
	
	@DeleteMapping("/delete/{id}/")
	public Object deleteById(@PathVariable("id") Integer id) {
		return productService.deleteById(id);
	}
	
	@PutMapping("/update/")
	public Object update(@RequestBody Product product) {
		
		if(productService.update(product) != null) {
			return productService.update(product);
		} else {
			return "Product not found";
		}
	}
	
	/**
	 * Truncate the table "products"
	 */
	@GetMapping("/truncate/")
	public Object truncate() {
		return productService.truncate();
	}

}
