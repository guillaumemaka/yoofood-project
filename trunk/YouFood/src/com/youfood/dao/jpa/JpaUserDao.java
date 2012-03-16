package com.youfood.dao.jpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.youfood.dao.UserDao;
import com.youfood.entity.User;
import com.youfood.exception.UserException;

@Stateless
public class JpaUserDao implements UserDao {

	@PersistenceContext(unitName = "YouFood-PU")
	private EntityManager em;

	@Override
	public User create(User user) throws UserException {
		try {
			em.persist(user);
		} catch (Exception e) {
			throw new UserException("Creation of the user: " + user
					+ " failed, please try later or contact the webmaster");
		}

		return user;
	}

	@Override
	public User update(User user) throws UserException {
		try {
			em.persist(em.merge(user));
		} catch (Exception e) {
			throw new UserException("Update of the user: " + user
					+ " failed, please try later or contact the webmaster");
		}

		return user;
	}

	@Override
	public Boolean delete(User user) throws UserException {
		try {
			em.remove(em.merge(user));
			return true;
		} catch (Exception e) {
			throw new UserException("Deletion of the user: " + user
					+ " failed, please try later or contact the webmaster");
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
			user = (User) em
					.createQuery(
							"select u from User where u.username = :username And u.password = :password ")
					.setParameter("username", username)
					.setParameter("password", password).getSingleResult();
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAll() {
		List<User> users = null;
		try {
			users = (List<User>) em.createQuery("SELECT u FROM User u")
					.getResultList();
			return users;
		} catch (Exception e) {
			return null;
		}

	}

}
