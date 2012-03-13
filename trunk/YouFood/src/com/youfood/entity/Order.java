package com.youfood.entity;

import static javax.persistence.TemporalType.DATE;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import com.youfood.entity.TTable;
import javax.persistence.ManyToOne;

@Entity(name = "Order")
@Table(name = "OrderTable")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	double price;
	@Temporal(DATE)
	Date date;
	@ManyToMany
	private Collection<Item> items;
	@ManyToOne
	private TTable table;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Collection<Item> getItems() {
		return items;
	}

	public void setItems(Collection<Item> param) {
		this.items = param;
	}

	public TTable getTable() {
		return table;
	}

	public void setTable(TTable param) {
		this.table = param;
	}

}
