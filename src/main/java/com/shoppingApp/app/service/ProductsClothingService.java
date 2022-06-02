package com.shoppingApp.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingApp.app.entity.Category;
import com.shoppingApp.app.entity.ProductClothingImages;
import com.shoppingApp.app.entity.ProductDtoClothing;
import com.shoppingApp.app.entity.ProductDtoEle;
import com.shoppingApp.app.entity.ProductElectronicsImages;
import com.shoppingApp.app.entity.ProductType;
import com.shoppingApp.app.entity.ProductsClothing;
import com.shoppingApp.app.entity.ProductsElectronic;
import com.shoppingApp.app.repo.CategoryRepoInterface;
import com.shoppingApp.app.repo.ProductTypeRepo;
import com.shoppingApp.app.repo.ProductsClothingRepo;

@Service
public class ProductsClothingService {
	
	@Autowired
	ProductsClothingRepo pcr;
	
	@Autowired
	private CategoryRepoInterface cr;
	
	@Autowired
	private ProductTypeRepo ptr;
	
	@Autowired
	private ModelMapper mm;
	
	public List<ProductsClothing> getAll(){
		
		return this.pcr.findAll();
	}
	
	public List<ProductsClothing> getTShirts(){
		ArrayList<ProductsClothing> tShirts=new ArrayList<>();
		List<ProductsClothing> ls= this.pcr.findAll();
		for (ProductsClothing productsClothing : ls) {
			if(productsClothing.getProductType().getName().equals("TShirt")) {
				tShirts.add(productsClothing);
			}
		}
		return tShirts;
	}
	
	public List<ProductsClothing> getShirts(){
		
		ArrayList<ProductsClothing> Shirts=new ArrayList<>();
		List<ProductsClothing> ls= this.pcr.findAll();
		for (ProductsClothing productsClothing : ls) {
			if(productsClothing.getProductType().getName().equals("Shirts")) {
				Shirts.add(productsClothing);
			}
		}
		return Shirts;
	}
	
public ProductsClothing saveProduct(ProductDtoClothing p) {
		
		Optional<Category> c= this.cr.findById(1);
		System.out.println(p.getPci().getImageName());
		ProductClothingImages pei=p.getPci();
		
		ProductType pt= this.ptr.findByName(p.getProductType());
		ProductsClothing pe=this.dtoToProductClothing(p);
		pei.setPcr(pe);
		pe.setCategory(c.get());
		pe.setProductType(pt);
		pe.setPci(pei);
		this.pcr.save(pe);
		return pe;
		
	}

public ProductsClothing dtoToProductClothing(ProductDtoClothing pc) {
	
	ProductsClothing pe=this.mm.map(pc, ProductsClothing.class);
	
	return pe;
	
	
}

}
