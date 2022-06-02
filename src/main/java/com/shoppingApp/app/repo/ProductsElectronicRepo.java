package com.shoppingApp.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingApp.app.entity.ProductsElectronic;

public interface ProductsElectronicRepo extends JpaRepository<ProductsElectronic, Integer> {

	
	public List<ProductsElectronic> findByNameContaining(String keyword);
	public List<ProductsElectronic> findByPriceLessThan(Integer amount);
}
