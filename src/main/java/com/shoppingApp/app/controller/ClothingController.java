package com.shoppingApp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingApp.app.entity.ProductDtoClothing;
import com.shoppingApp.app.entity.ProductsClothing;
import com.shoppingApp.app.entity.ProductsElectronic;
import com.shoppingApp.app.repo.ProductsClothingRepo;
import com.shoppingApp.app.service.ProductsClothingService;

@CrossOrigin
@RestController
@RequestMapping("list")
public class ClothingController {
	
	@Autowired
	ProductsClothingService pcs;
	
	@Autowired
	ProductsClothingRepo pcr;
	
	@GetMapping("/clothing")
	public List<ProductsClothing> getAllClothing(){
		
		return this.pcs.getAll();
	}
	
	@GetMapping("/tshirts")
	public List<ProductsClothing> getAllTshirts(){
		
		return this.pcs.getTShirts();
	}
	
	@GetMapping("/shirts")
public List<ProductsClothing> getAllShirts(){
		
		return this.pcs.getShirts();
	}
	@GetMapping("price-clothing/{amount}")
	public List<ProductsClothing> getPriceResult(@PathVariable Integer amount){
		
		return this.pcr.findByPriceLessThan(amount);
	}
	
	@PostMapping("save-clothing")
	public ProductsClothing save(@RequestBody ProductDtoClothing pdt) {
		
		return this.pcs.saveProduct(pdt);
		
	}

}
