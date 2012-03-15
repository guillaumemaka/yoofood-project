package com.youfood.dao;

import javax.ejb.Local;
import javax.servlet.http.HttpSession;

import com.youfood.backoffice.utils.AuthenticationError;
import com.youfood.exception.ConnexionException;

@Local
public interface AuthentificationDao {
	public AuthenticationError connect(String username, String password) throws ConnexionException, Exception;
	public Boolean disconnect(HttpSession session) throws Exception;	
}
