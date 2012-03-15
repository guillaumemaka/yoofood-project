package com.youfood.backoffice.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;

import com.youfood.dao.AuthentificationDao;
import com.youfood.dao.jpa.JpaUserDao;
import com.youfood.entity.User;
.youfood.entity.User;

public class Authenticator implements AuthentificationDao{	
	private String userFullName;
	private Long userId;
	
	@EJB 
	private JpaUserDao userDao;
	
	public Authenticator(){
		
	}
	
	public AuthenticationError connect(String username, String password) throws Exception{
		
				
		String hashed_password = Authentication.hash(password, "UTF-8");
				
		User user;
		
		try {
			user = userDao.findUserByUsernameAndPassword(username, hashed_password);
		} catch (NoResultException e) {			
			user = null;
		}
						
		if ( user == null ){
			return AuthenticationError.UserNotFound;
		}	
		
		this.userFullName = user.getFullname();
		this.userId = user.getId();
		
		return AuthenticationError.Success;
	}

	public String getUserFullName() {
		return this.userFullName;
	}

	public Long getUserId() {
		return this.userId;
	}	
	
	
	/**
	 * 
	 * Static method
	 * @throws Exception 
	 * 
	 */
	
	public static String hash(String data, String charset) throws Exception{
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.reset();
		md.update(data.getBytes(charset),0,data.length());
		String hash = new BigInteger(1,md.digest()).toString(16);
		return hash;
	}

	@Override
	public Boolean disconnect(HttpSession session) throws Exception {
		try {
			session.invalidate();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	
	
}
