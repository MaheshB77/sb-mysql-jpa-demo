package com.mahesh.sbmysqljpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mahesh.sbmysqljpademo.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Modifying
	@Query(value = "TRUNCATE TABLE products", nativeQuery = true)
	public void truncateProduct();
}
