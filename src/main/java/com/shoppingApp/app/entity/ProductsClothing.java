package com.shoppingApp.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class ProductsClothing {
	
	@Id
	private int id;
	private String name;
	@ManyToOne
	@JsonIgnore
	private Category category;
	@ManyToOne
	@JsonIgnore
	private ProductType productType;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "pcr")
	private ProductClothingImages pci;
	private String size;
	private String colour;
	private String sleeves;
	private int price;

}
