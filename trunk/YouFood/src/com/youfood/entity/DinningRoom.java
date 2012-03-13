package com.youfood.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.youfood.entity.Restaurant;
import javax.persistence.ManyToOne;

@Entity
public class DinningRoom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@OneToMany(mappedBy = "dinningRoom")
	private Collection<Zone> zones;
	@ManyToOne
	private Restaurant restaurant;

	public DinningRoom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<Zone> getZones() {
		return zones;
	}

	public void setZones(Collection<Zone> param) {
		this.zones = param;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant param) {
		this.restaurant = param;
	}

}