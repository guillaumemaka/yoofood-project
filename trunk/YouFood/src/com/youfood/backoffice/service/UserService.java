package com.youfood.backoffice.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.youfood.dao.jpa.JpaUserDao;
import com.youfood.entity.User;

public @Stateless class UserService {
	@EJB
	private JpaUserDao userDao;
	
	public User findUserByUsernameAndPassword(String username, String password){
		return userDao.findUserByUsernameAndPassword(username, password);
	}
}
