package com.qaprosoft.dao;

import java.util.ArrayList;

import com.qaprosoft.entity.Track;

public interface ITrackDAO {
	
	public ArrayList<Track> getAll();
	
	public Track getById(Long id);
	
	public void deleteById(Long id);
	
	public void createNewTrack(Track track);

}
