package com.shoppingApp.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingApp.app.entity.ProductsClothing;
import com.shoppingApp.app.entity.ProductsElectronic;

public interface ProductsClothingRepo extends JpaRepository<ProductsClothing, Integer> {

	public List<ProductsClothing> findByNameContaining(String keyword);
	public List<ProductsClothing> findByPriceLessThan(Integer amount);
}
