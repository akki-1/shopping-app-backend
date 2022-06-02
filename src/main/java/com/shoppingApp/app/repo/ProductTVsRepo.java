package com.shoppingApp.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingApp.app.entity.ProductTVs;

public interface ProductTVsRepo extends JpaRepository<ProductTVs, Integer> {

	public List<ProductTVs> findByNameContaining(String keyword);
	public List<ProductTVs> findByPriceLessThan(Integer amount);
}
