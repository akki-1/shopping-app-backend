package com.shoppingApp.app.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingApp.app.entity.AllProducts;
import com.shoppingApp.app.repo.ProductsClothingRepo;
import com.shoppingApp.app.repo.ProductsElectronicRepo;

@Service
public class AllProductsService {
	
	@Autowired
	ProductsElectronicRepo per;
	
	@Autowired
	ProductsClothingRepo pcr;
	
	ArrayList<AllProducts> ar;
	
	public ArrayList<AllProducts> allProducts(){
		this.ar=new ArrayList<AllProducts>();
		AllProducts p=new AllProducts();
		
		p.setClothing(this.pcr.findAll());
		p.setElectronic(this.per.findAll());
		this.ar.add(p);
		return this.ar;
		
	}
	
	public ArrayList<AllProducts> searchProduct(String keyword){
		ArrayList<AllProducts> ar=new ArrayList<>();
		AllProducts p=new AllProducts();
		p.setElectronic(this.per.findByNameContaining(keyword));
		p.setClothing(this.pcr.findByNameContaining(keyword));
		ar.add(p);
		return ar;
		
		
	}

}
