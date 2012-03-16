package com.youfood.dao;

import java.util.List;

import com.youfood.entity.User;
import com.youfood.exception.UserException;

public interface UserDao {
	public User find(Long id);
	public List<User> findAll();
	public User findUserByUsernameAndPassword(String username, String password);
	public User create(User user) throws UserException;
	public User update(User user) throws UserException;
	public Boolean delete(User user) throws UserException;	
}
