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

	@Override
	public User find(Long id) {
		User user = new User();
		
		try {
			user = em.find(User.class, id);
			return user;
		} catch (Exception e) {
			return null;
		}		
	}

	@Override
	public User findUserByUsernameAndPassword(String username, String password) {
		User user = new User();
		try {
			user = (User) em.createQuery("select u from User where u.username= :username And u.password = :password ")
				.setParameter("username", username)
				.setParameter("password", password)
				.getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

}
