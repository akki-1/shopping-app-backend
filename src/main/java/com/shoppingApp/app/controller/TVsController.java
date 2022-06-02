package com.shoppingApp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingApp.app.entity.ProductTVs;
import com.shoppingApp.app.repo.ProductTVsRepo;
import com.shoppingApp.app.service.ProductTVsService;

@CrossOrigin
@RestController
@RequestMapping("list")
public class TVsController {
	
	@Autowired
	ProductTVsService pts;
	
	@Autowired
	ProductTVsRepo ptr;
	
	
	@GetMapping("tvs")
	public List<ProductTVs> getAll(){
		
		return this.ptr.findAll();
	}
	

}
