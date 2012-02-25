package com.supinfo.notetonsta.dao;


import java.util.List;

import com.supinfo.notetonsta.entity.Intervention;

public interface InterventionDao {
	public Intervention find(int intervention_id);
	public List<Intervention> findAll();
	public void addIntervention(Intervention intervention);
	public void removeIntervention(Intervention intervention);
	public void updateIntervention(Intervention intervention);	
}
