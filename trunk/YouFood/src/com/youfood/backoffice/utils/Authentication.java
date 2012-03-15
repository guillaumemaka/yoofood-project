package com.youfood.backoffice.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.youfood.dao.AuthentificationDao;
import com.youfood.entity.User;

public class Authentication implements AuthentificationDao{
	private String username;
	private String password;
	private String userFullName;
	private int userId;
	
	public Authentication(){
		
	}
	
	public AuthenticationError authenticate() throws Exception{
		EntityManager em = PersistenceManager.getEntityManagerFactory().createEntityManager();
				
		String hashed_password = Authentication.hash(this.password, "UTF-8");
				
		User user;
		
		try {
			em.getTransaction().begin();
			user = (User) em.createQuery("SELECT u FROM User AS u WHERE u.email = :email")
			.setParameter("email", this.username).getSingleResult();
			
			em.getTransaction().commit();			
		} catch (NoResultException e) {			
			user = null;
		}finally{
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}
			
			if(em.isOpen()){
				em.close();
			}
		}
				
		
		if ( user == null ){
			return AuthenticationError.UserNotFound;
		}else if ( ! user.getPassword().equals(hashed_password)){
			
			System.out.println("Plain text password:" + this.password);
			System.out.println("DB hashed password:" + user.getPassword());
			System.out.println("Plain text hashed password:" + hashed_password);
			
			return AuthenticationError.PasswordMissMatch;
		}		
		
		this.userFullName = user.getFirstname() + " " + user.getLastname();
		this.userId = user.getId();
		
		return AuthenticationError.Success;
	}
	
	public Authentication setCredentials(String username, String password){
		this.username = username;
		this.password = password;
		
		return this;
	}

	public String getUserFullName() {
		// TODO Auto-generated method stub
		return this.userFullName;
	}

	public int getUserId() {
		// TODO Auto-generated method stub
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
	
}
