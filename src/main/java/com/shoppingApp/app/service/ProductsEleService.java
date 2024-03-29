package com.shoppingApp.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingApp.app.entity.Category;
import com.shoppingApp.app.entity.ProductDtoEle;
import com.shoppingApp.app.entity.ProductElectronicsImages;
import com.shoppingApp.app.entity.ProductType;
import com.shoppingApp.app.entity.ProductsElectronic;
import com.shoppingApp.app.repo.CategoryRepoInterface;
import com.shoppingApp.app.repo.ProductTypeRepo;
import com.shoppingApp.app.repo.ProductsElectronicRepo;

@Service
public class ProductsEleService {

	@Autowired
	private ProductsElectronicRepo pe;
	
	@Autowired
	private ModelMapper mm;
	
	@Autowired
	private CategoryRepoInterface cr;
	
	@Autowired
	private ProductTypeRepo ptr;

	private List<ProductsElectronic> listLaptops;

	public List<ProductsElectronic> listLaptop() {
		this.listLaptops = new ArrayList<ProductsElectronic>();
		for (ProductsElectronic productsElectronic : this.pe.findAll()) {
			System.out.println(productsElectronic.getProductType().getName());
			if (productsElectronic.getProductType().getName().equals("Laptop")) {
				this.listLaptops.add(productsElectronic);
			}

		}

		return this.listLaptops;
	}
	
	public List<ProductsElectronic> listMobiles(){
		
		ArrayList<ProductsElectronic> listMobile=new ArrayList<ProductsElectronic>();
		for (ProductsElectronic productsElectronic : this.pe.findAll()) {
			System.out.println(productsElectronic.getProductType().getName());
			if (productsElectronic.getProductType().getName().equals("Mobile")) {
				listMobile.add(productsElectronic);
			}

		}
		return listMobile;
		
	}
	
	public ProductsElectronic saveProduct(ProductDtoEle p) {
		
		Optional<Category> c= this.cr.findById(1);
		ProductElectronicsImages pei=p.getPi();
		
		ProductType pt= this.ptr.findByName(p.getProductType());
		ProductsElectronic pe=this.dtoToPe(p);
		pei.setPe(pe);
		pe.setCategory(c.get());
		pe.setProductType(pt);
		pe.setPi(pei);
		this.pe.save(pe);
		return pe;
		
	}
	
	public ArrayList<ProductsElectronic> search(String keyword) {
		System.out.println(keyword);
		ArrayList<ProductsElectronic> searchList=new ArrayList<>();
		List<ProductsElectronic> listAll= this.pe.findAll();
		for (ProductsElectronic productsElectronic : listAll) {
			System.out.println(productsElectronic.getName());
			if(productsElectronic.getName().contentEquals(keyword)) {
				searchList.add(productsElectronic);
			}
		}
		return searchList;
	}
	
	public ProductsElectronic dtoToPe(ProductDtoEle p) {
		
		ProductsElectronic pe=this.mm.map(p, ProductsElectronic.class);
		
		return pe;
		
		
	}

}
