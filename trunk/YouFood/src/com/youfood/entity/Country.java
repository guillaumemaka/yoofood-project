package com.youfood.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.youfood.entity.Restaurant;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
public class Country implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String currency;

	private Double taxes;

	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getTaxes() {
		return taxes;
	}

	public void setTaxes(Double taxes) {
		this.taxes = taxes;
	}

	@OneToMany(mappedBy = "country")
	private Collection<Restaurant> restaurants;

	public Collection<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(Collection<Restaurant> param) {
		this.restaurants = param;
	}

}
