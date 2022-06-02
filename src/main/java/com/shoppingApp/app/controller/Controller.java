package com.shoppingApp.app.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shoppingApp.app.entity.AllProducts;
import com.shoppingApp.app.entity.ProductDtoEle;
import com.shoppingApp.app.entity.ProductsClothing;
import com.shoppingApp.app.entity.ProductsElectronic;
import com.shoppingApp.app.repo.ProductsClothingRepo;
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
	
	@Autowired
	ProductsClothingRepo pcr;
	
	@Value("${location.image}")
	private String path;
	
	@GetMapping("/all")
	public ArrayList<AllProducts> allList() {
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
	
	@PostMapping("search/{keyword}")
	public List<ProductsElectronic> searchProduct(@PathVariable String keyword,String search) {
			System.out.println(keyword);
			return this.per.findByNameContaining(keyword);
		
	}
	@PostMapping("search-clothing/{keyword}")
	public List<ProductsClothing> searchProductClothing(@PathVariable String keyword,String search) {
			System.out.println(keyword);
			return this.pcr.findByNameContaining(keyword);
		
	}
	
	@GetMapping("price-electronic/{amount}")
	public List<ProductsElectronic> getPriceResult(@PathVariable Integer amount){
		
		return this.per.findByPriceLessThan(amount);
	}
	
	
	
	@PostMapping("save-product")
	
	public ProductsElectronic saveProductElectronic(@RequestBody ProductDtoEle p) {
//		System.out.println(image.getOriginalFilename());
//		return null;
		return this.ps.saveProduct(p);
	}
	
	@PostMapping("save-image")
	public boolean saveImage(@RequestParam("image") MultipartFile image) {
		String name=image.getOriginalFilename();
		String imagePath = path + File.separator + name;
		try {
			Files.copy(image.getInputStream(), Paths.get(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
}
