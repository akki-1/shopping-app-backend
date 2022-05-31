package com.shoppingApp.app.entity.productTypes;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class Laptop {
	
	
	private int laptopRAM;
	private int laptopROM;
	private String laptopScreenSize;

}
