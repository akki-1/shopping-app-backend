package com.shoppingApp.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingApp.app.entity.ProductType;

public interface ProductTypeRepo extends JpaRepository<ProductType, Integer> {

	ProductType findByName(String name);
	
	
	

}
