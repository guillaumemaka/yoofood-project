package com.youfood.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.youfood.entity.DinningRoom;
import java.util.Collection;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String name;
	String address;
	@ManyToOne
	private Country country;
	@OneToMany(mappedBy = "restaurant")
	private Collection<DinningRoom> dinningRoom;

	public Restaurant() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country param) {
		this.country = param;
	}

	public Collection<DinningRoom> getDinningRoom() {
		return dinningRoom;
	}

	public void setDinningRoom(Collection<DinningRoom> param) {
		this.dinningRoom = param;
	}

}