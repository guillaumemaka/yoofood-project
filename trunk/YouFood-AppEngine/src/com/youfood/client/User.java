package com.youfood.client;

import java.io.Serializable;

//@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.WRAPPER_OBJECT) 
public class User implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String lastname;
	
	private String firstname;
	
	public User(){};
	public User(String lname,String fname){
		this.firstname = fname;
		this.lastname = lname;
	}
	
	//@JsonProperty("lastname")
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	//@JsonProperty("firstname")
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
