package com.supinfo.notetonsta.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the interventions database table.
 * 
 */
@Entity
@Table(name = "interventions")
public class Intervention implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Lob
	@Column(name = "description")
	private String description;

	@Column(name = "endDate")
	private String endDate;

	@Column(name = "startDate")
	private String startDate;

	@Column(name = "subject")
	private String subject;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "speaker_id" )
	private Speaker speaker;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "campus_id")
	private Campus campus;

	@OneToMany(mappedBy="intervention",fetch=FetchType.EAGER)
	private Set<Mark> marks;

	public Intervention() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Speaker getSpeaker() {
		return this.speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus param) {
		this.campus = param;
	}

	public void setMarks(Set<Mark> marks) {
		this.marks = marks;
	}

	public Set<Mark> getMarks() {
		return this.marks;
	}
	
	
	/*
	 * 
	 * Get the Status of the current intervention
	 * @return String Not Started | In progress | Done
	 * 
	 */
	public String getStatus() {
		// TODO Auto-generated method stub		
		
		/*
		 * 
		 * Get the current date 
		 * 
		 */
		
		Date now = GregorianCalendar.getInstance().getTime();
		
		/*
		 * 
		 * Parse the intervention startDate
		 * 
		 */
		
		Date startDate = null;
		try {
			startDate = new SimpleDateFormat("MM/dd/yyyy").parse(this.getStartDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * 
		 * Parse the intervention endDate
		 * 
		 */
		
		Date endDate = null;
		try {
			endDate = new SimpleDateFormat("MM/dd/yyyy").parse(this.getEndDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		########## Log #############
		
//		System.out.println(startDate.toString());
//		System.out.println(endDate.toString());
//		System.out.println(now.toString());
//		System.out.println(years[0][0] + ", " + years[0][1]);

		//		########## Log #############
		

		/*
		 * 
		 * Status Logic definition 
		 * 
		 */
		
		if (now.after(startDate) && now.before(endDate)){
			return "In progress";
		}else if(now.before(startDate)){
			return "Not started";
		}else if(now.after(endDate)){
			return "Done";
		}
		
		
		return null;
	}
}