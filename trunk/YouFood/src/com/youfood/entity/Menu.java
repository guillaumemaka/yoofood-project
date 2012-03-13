package com.youfood.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.youfood.entity.Item;
import java.util.Collection;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

@Entity
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String theme;
	@Temporal(DATE)
	Date createdAt;
	@Temporal(DATE)
	Date lastUsed; // date d'utilisation du menu dans les restaurants
	@ManyToMany(mappedBy = "menus")
	private Collection<Item> items;

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}

	public Collection<Item> getItems() {
		return items;
	}

	public Collection<Item> getMenu_items() {
		return items;
	}

	public void setItems(Collection<Item> param) {
		this.items = param;
	}

}
