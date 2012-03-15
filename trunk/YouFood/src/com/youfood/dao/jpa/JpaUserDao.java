package com.youfood.dao.jpa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.youfood.dao.UserDao;
import com.youfood.entity.User;

@Stateless
public class JpaUserDao implements UserDao{
	
	@PersistenceContext(unitName="ùù")
	private EntityManager em;
	@Override
	
	public User create(User user) {
		try {
			em.persist(user);
		} catch (Exception e) {
			return null;
		}
		
		return user;
	}

	@Override
	public User update(User user) {
		try {
			em.persist(em.merge(user));
		} catch (Exception e) {
			return null;
		}
		
		return user;
	}

	@Override
	public Boolean delete(User user) {
		try {
			em.remove(em.merge(user));
			return true;
		} catch (Exception e) {
			return false;
		}		
	}

}
