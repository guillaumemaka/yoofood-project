package com.youfood.dao;

import java.util.List;

import com.youfood.entity.User;

public interface UserDao {
	public User find(Long id);
	public List<User> findAll();
	public User findUserByUsernameAndPassword(String username, String password);
	public User create(User user);
	public User update(User user);
	public Boolean delete(User user);	
}
