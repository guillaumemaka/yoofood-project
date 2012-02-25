package com.supinfo.notetonsta.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the marks database table.
 * 
 */
@Entity
@Table(name="marks")
public class Mark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="slide_mark")
	private Double slideMark;

	@Column(name="speaker_mark")
	private Double speakerMark;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="intervention_id")
	private Intervention intervention;

	private String idbooster;
	
	@Lob
	private String coment;
	
	public Mark() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getSpeakerMark() {
		return this.speakerMark;
	}

	public void setSpeakerMark(Double speakerMark) {
		this.speakerMark = speakerMark;
	}

	public Intervention getIntervention() {
	    return this.intervention;
	}

	public void setIntervention(Intervention intervention) {
	    this.intervention = intervention;
	}

	public String getIdbooster() {
		return idbooster;
	}

	public void setIdbooster(String idbooster) {
		this.idbooster = idbooster;
	}

	public String getComent() {
		return coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	public void setSlideMark(Double slideMark) {
		this.slideMark = slideMark;
	}
	
	public Double getSlideMark(){
		return this.slideMark;
	}
}