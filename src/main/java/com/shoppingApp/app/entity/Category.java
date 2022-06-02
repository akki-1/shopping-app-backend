package com.shoppingApp.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
public class Category {
	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<ProductsElectronic> products;
	@OneToMany(mappedBy = "category")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ProductsClothing>   pt;
	@OneToMany(mappedBy = "category")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ProductTVs>  tvs;
}
