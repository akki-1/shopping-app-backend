package com.shoppingApp.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductClothingImages {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String imageName;
	private long size;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	ProductsClothing pcr;

}
