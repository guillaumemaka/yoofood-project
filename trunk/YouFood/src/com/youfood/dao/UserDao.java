package com.youfood.dao;

import com.youfood.entity.User;

public interface UserDao {
	public User create(User user);
	public User update(User user);
	public Boolean delete(User user);	
}
