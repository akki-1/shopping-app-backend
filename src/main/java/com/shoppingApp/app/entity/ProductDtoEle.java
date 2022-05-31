package com.shoppingApp.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoEle {
	
	private String name;
	private int ram;
	private int rom;
	private String screenSize;
	private ProductType productType;

}
