package com.shoppingApp.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingApp.app.entity.ProductDtoEle;
import com.shoppingApp.app.entity.Products;
import com.shoppingApp.app.entity.ProductsElectronic;
import com.shoppingApp.app.repo.ProductsElectronicRepo;
import com.shoppingApp.app.service.AllProductsService;
import com.shoppingApp.app.service.ProductsEleService;


@CrossOrigin
@RestController
@RequestMapping("list")
public class Controller {

	@Autowired
	ProductsEleService ps;
	
	@Autowired
	ProductsElectronicRepo per;
	
	@Autowired
	AllProductsService aps;
	
	@GetMapping("/all")
	public ArrayList<Products> allList() {
		return this.aps.allProducts();
		
	}
	
	@GetMapping("/electronic")
	public List<ProductsElectronic> getElectronics() {

		return this.per.findAll();
	}

	@GetMapping("/laptop")
	public List<ProductsElectronic> getLaptops() {

		return this.ps.listLaptop();
	}

	@GetMapping("/mobiles")
	public List<ProductsElectronic> getMobiles() {

		return this.ps.listMobiles();
	}
	
	@PostMapping("save-product")
	
	public ProductsElectronic saveProductElectronic(@RequestBody ProductDtoEle p) {
		
		
		return this.ps.saveProduct(p);
	}
	
	
}
