package com.supinfo.notetonsta.dao;


import java.util.List;

import com.supinfo.notetonsta.entity.Campus;

public interface CampusDao {
	public Campus find(int campus_id);
	public List<Campus> findAll();
	public void addCampus(Campus campus);
	public void removeCampus(Campus campus);
}
