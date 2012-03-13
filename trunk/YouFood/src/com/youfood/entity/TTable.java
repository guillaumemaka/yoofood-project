package com.youfood.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Basic
	private String libelle;

	@ManyToOne
	private Zone zone;

	public TTable() {
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

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone param) {
		this.zone = param;
	}

}
