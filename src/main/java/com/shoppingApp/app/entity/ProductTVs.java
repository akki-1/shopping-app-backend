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
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ProductTVs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String price;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Category category;
	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private ProductType productType;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private TVsImages tvImage;
	private String display;
	private String smartTV;
	private String sound;
	private String os;

}
