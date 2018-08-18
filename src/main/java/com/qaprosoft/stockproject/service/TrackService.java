package com.qaprosoft.stockproject.service;

import java.util.ArrayList;

import com.qaprosoft.stockproject.dao.jdbc.impl.TrackDAO;
import com.qaprosoft.stockproject.entity.transport.Track;

public class TrackService {
	
	private TrackDAO tDAO = new TrackDAO();
	
	public ArrayList<Track> getAll() {
		ArrayList<Track> allTracks = tDAO.getAll();
		return allTracks;
	}
	
	public Track getById(Long id) {
		Track track = tDAO.getById(id);
		return track;
	}
	
	public void deleteById(Long id) {
		tDAO.deleteById(id);
	}
	
	

}
