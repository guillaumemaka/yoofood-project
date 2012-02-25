package com.supinfo.notetonsta.dao;


import java.util.List;

import org.jCharts.chartData.ChartDataException;
import org.jCharts.chartData.PieChartDataSet;
import com.supinfo.notetonsta.entity.Intervention;
import com.supinfo.notetonsta.entity.Mark;

public interface MarkDao {
	public Mark find(int mark_id);
	public List<Mark> findAll();
	public void addMark(Mark mark);
	public void removeMark(Mark mark);
	public Object getStatsForIntervention(Intervention intervention);
	public PieChartDataSet getDataSetChartForIntervention(Intervention intervention) throws ChartDataException;
}
