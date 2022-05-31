package com.shoppingApp.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingApp.app.entity.ProductsClothing;
import com.shoppingApp.app.repo.ProductsClothingRepo;

@Service
public class ProductsClothingService {
	
	@Autowired
	ProductsClothingRepo pcr;
	
	public List<ProductsClothing> getAll(){
		
		return this.pcr.findAll();
	}

}
