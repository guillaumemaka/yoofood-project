package com.supinfo.notetonsta.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.supinfo.notetonsta.dao.InterventionDao;
import com.supinfo.notetonsta.entity.Intervention;

public class JpaInterventionDao implements InterventionDao {
	private EntityManagerFactory emf = null;
	private EntityManager em;
	
	public JpaInterventionDao(EntityManagerFactory entityManagerFactory) {
		// TODO Auto-generated constructor stub
		this.emf = entityManagerFactory;
		this.em = emf.createEntityManager();		
	}

	@Override
	public Intervention find(int intervention_id) {
		// TODO Auto-generated method stub		
		em.getTransaction().begin();	 	 
		Intervention intervention = em.find(Intervention.class, intervention_id);
		em.getTransaction().commit();
		em.close();
		
		if (intervention == null) {
			intervention = new Intervention();
		}
		
		return intervention;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Intervention> findAll() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();	 	 
		List<Intervention> interventions = em.createQuery("SELECT i FROM Intervention AS i").getResultList();
		em.getTransaction().commit();
		em.close();
		
		return interventions;
	}

	@Override
	public void addIntervention(Intervention intervention) {
		// TODO Auto-generated method stub
		
		
		try {
			em.getTransaction().begin();
			em.persist(intervention);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(em.getTransaction().isActive()){
				em.getTransaction().rollback();
			}			
		}
	}

	@Override
	public void removeIntervention(Intervention intervention) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			
			em.createQuery("DELETE FROM Intervention AS i WHERE i.id = :intervention_id")
			.setParameter("intervention_id", intervention.getId())
			.executeUpdate();	
			
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if( em.getTransaction().isActive() ) em.getTransaction().rollback();
			if( em.isOpen() ) em.close();
		}
	}

	@Override
	public void updateIntervention(Intervention intervention) {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			
			em.merge(intervention);
			
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if( em.getTransaction().isActive() ) em.getTransaction().rollback();
			if( em.isOpen() ) em.close();
			e.printStackTrace();
		}
	}
}
