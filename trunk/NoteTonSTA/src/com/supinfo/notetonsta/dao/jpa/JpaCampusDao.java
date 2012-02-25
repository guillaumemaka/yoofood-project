package com.supinfo.notetonsta.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.supinfo.notetonsta.dao.CampusDao;
import com.supinfo.notetonsta.entity.Campus;

public class JpaCampusDao implements CampusDao {
	private EntityManagerFactory emf = null;
	private EntityManager em;
	
	public JpaCampusDao(EntityManagerFactory entityManagerFactory) {
		// TODO Auto-generated constructor stub
		this.emf = entityManagerFactory;
		this.em = emf.createEntityManager();
	}

	@Override
	public Campus find(int campus_id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Campus campus = em.find(Campus.class, campus_id);
		em.getTransaction().commit();
		em.close();
		
		return campus;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Campus> findAll() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();		
		List<Campus> camps = em.createQuery("SELECT c FROM Campus AS c").getResultList();
		em.getTransaction().commit();
		em.close();
		
		return camps;
	}

	@Override
	public void addCampus(Campus campus) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.persist(campus);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void removeCampus(Campus campus) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.merge(campus));
		em.getTransaction().commit();
		
		em.close();
	}

}
