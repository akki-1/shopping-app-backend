package com.shoppingApp.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class ProductsElectronic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Category category;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private ProductType productType;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private ProductElectronicsImages pi;
	private int ram;
	private int rom;
	private String screenSize;
	private int price;

}
