package com.supinfo.notetonsta.dao.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.supinfo.exception.SpeakerCreationException;
import com.supinfo.exception.SpeakerDeletionException;
import com.supinfo.notetonsta.dao.SpeakerDao;
import com.supinfo.notetonsta.entity.Speaker;

public class JpaSpeakerDao implements SpeakerDao {
	private EntityManagerFactory emf = null;
	private EntityManager em;
	
	public JpaSpeakerDao(EntityManagerFactory entityManagerFactory) {
		// TODO Auto-generated constructor stub
		this.emf = entityManagerFactory;
		this.em = emf.createEntityManager();
	}

	@Override
	public Speaker find(int speaker_id) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		Speaker speaker = em.find(Speaker.class, speaker_id); 
		em.getTransaction().commit();
		em.close();
		
		return speaker;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Speaker> findAll() {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		List<Speaker> speakers = em.createQuery("SELECT s FROM Speaker AS s").getResultList();		
		em.getTransaction().commit();
		em.close();
		
		return speakers;
		
	}

	@Override
	public void addSpeaker(Speaker speaker) throws SpeakerCreationException {
		// TODO Auto-generated method stub
		try {
			em.getTransaction().begin();
			em.persist(speaker);
			em.getTransaction().commit();
			em.close();			
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			em.getTransaction().rollback();			
		}
	}

	@Override
	public void removeSpeaker(Speaker speaker) throws SpeakerDeletionException {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.remove(em.merge(speaker));
		em.getTransaction().commit();
		em.close();
	}

}
