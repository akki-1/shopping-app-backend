package com.shoppingApp.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingApp.app.entity.ProductTVs;
import com.shoppingApp.app.repo.ProductTVsRepo;

@Service
public class ProductTVsService {
	
	@Autowired
	ProductTVsRepo ptr;
	
	public List<ProductTVs> listSmartTVs() {
		List<ProductTVs> listSmartTVs = new ArrayList<>();
		for (ProductTVs productTVs : this.ptr.findAll()) {
			System.out.println(productTVs.getProductType().getName());
			if (productTVs.getProductType().getName().equals("Smart")) {
				listSmartTVs.add(productTVs);
			}

		}

		return listSmartTVs;
	}

}
