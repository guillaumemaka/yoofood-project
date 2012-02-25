package com.supinfo.notetonsta.dao;


import java.util.List;

import com.supinfo.exception.SpeakerCreationException;
import com.supinfo.exception.SpeakerDeletionException;
import com.supinfo.notetonsta.entity.Speaker;

public interface SpeakerDao {
	public Speaker find(int speaker_id);
	public List<Speaker> findAll();
	public void addSpeaker(Speaker speaker) throws SpeakerCreationException;
	public void removeSpeaker(Speaker speaker) throws SpeakerDeletionException;
}
