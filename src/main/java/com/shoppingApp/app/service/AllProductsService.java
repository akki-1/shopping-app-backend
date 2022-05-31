package com.shoppingApp.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingApp.app.entity.Products;
import com.shoppingApp.app.entity.ProductsClothing;
import com.shoppingApp.app.entity.ProductsElectronic;
import com.shoppingApp.app.repo.ProductsClothingRepo;
import com.shoppingApp.app.repo.ProductsElectronicRepo;

@Service
public class AllProductsService {
	
	@Autowired
	ProductsElectronicRepo per;
	
	@Autowired
	ProductsClothingRepo pcr;
	
	ArrayList<Products> ar;
	
	public ArrayList<Products> allProducts(){
		this.ar=new ArrayList<Products>();
		Products p=new Products();
		
		p.setClothing(this.pcr.findAll());
		p.setElectronic(this.per.findAll());
		ar.add(p);
		for (Products products : ar) {
			for (ProductsElectronic products2 : products.getElectronic()) {
				System.out.println(products2.getName());
			}
			for (ProductsClothing products2 : products.getClothing()) {
				System.out.println(products2.getName());
			}
			
		}
		return ar;
		
	}

}
