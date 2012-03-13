package com.youfood.entity;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Zone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Basic
	private String libelle;

	@ManyToOne
	private DinningRoom dinningRoom;

	@OneToMany(mappedBy = "zone")
	private Collection<TTable> tables;

	public Zone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public DinningRoom getDinningRoom() {
		return dinningRoom;
	}

	public void setDinningRoom(DinningRoom param) {
		this.dinningRoom = param;
	}

	public Collection<TTable> getTables() {
		return tables;
	}

	public void setTables(Collection<TTable> param) {
		this.tables = param;
	}

}
