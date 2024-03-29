package com.shoppingApp.app.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AllProducts {
	
	private List<ProductsClothing> clothing;
	private List<ProductsElectronic> electronic;

}
