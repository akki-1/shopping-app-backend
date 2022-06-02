package com.shoppingApp.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoClothing {
	
	private int price;
	private String name;
	private String size;
	private String colour;
	private String sleeves;
	private String productType;
	private ProductClothingImages pci;

}
