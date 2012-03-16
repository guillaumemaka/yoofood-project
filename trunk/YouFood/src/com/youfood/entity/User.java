package com.youfood.entity;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.AUTO;

/**
 * Entity implementation class for Entity: User
 * 
 */
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	@Basic
	private String username;
	@Basic
	private String password;
	@Basic
	private String firstname;

	@Basic
	private String lastname;

	public User() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstname(String param) {
		this.firstname = param;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setLastname(String param) {
		this.lastname = param;
	}

	public String getLastname() {
		return lastname;
	}

	@Override
	public String toString() {
		return this.getFirstname() + " " + this.getLastname();
	}

}
