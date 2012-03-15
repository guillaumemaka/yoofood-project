package com.youfood.dao;

import javax.ejb.Local;

import com.youfood.exception.ConnexionException;

@Local
public interface AuthentificationDao {
	public Boolean connect(String username, String password) throws ConnexionException;
	public Boolean disconnect() throws Exception;	
}
