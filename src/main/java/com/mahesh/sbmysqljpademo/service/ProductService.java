package com.mahesh.sbmysqljpademo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahesh.sbmysqljpademo.entity.Product;
import com.mahesh.sbmysqljpademo.repository.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	public Product save(Product product) {
		return productRepo.save(product);
	}
	
	public List<Product> saveAll(List<Product> products) {
		return productRepo.saveAll(products);
	}
	
	public Product getById(Integer id) {
		Optional<Product> product = productRepo.findById(id);
		
		if(product.isPresent()) {
			return product.get();
		} else {
			return null;
		}
	}
	
	public String deleteById(Integer id) {
		Product product = productRepo.findById(id).orElse(null);
		if (product != null) {
			productRepo.deleteById(id);
			return "Product deleted successfully!! " ; 
		} else {
			return "Product not found ";
		}
	}
	
	public Product update(Product product) {
		Optional<Product> oldProduct = productRepo.findById(product.getId());
		if(oldProduct.isPresent()) {
			Product _oldProduct = oldProduct.get();
			_oldProduct.setProductName(product.getProductName());
			_oldProduct.setProductPrice(product.getProductPrice());
			_oldProduct.setQuantity(product.getQuantity());
			productRepo.save(_oldProduct);
			return _oldProduct;
		} else {
			return null;
		}
	}
	
	/**
	 * Truncates the table "products"
	 */
	@Transactional
	public String truncate() {
		productRepo.truncateProduct();
		return "Table truncated successfully !!";
	}
}
