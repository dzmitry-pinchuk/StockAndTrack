package com.qaprosoft.stockproject.service.impl;

import java.util.ArrayList;

import com.qaprosoft.stockproject.dao.jdbc.impl.TrackDAO;
import com.qaprosoft.stockproject.entity.transport.Track;
import com.qaprosoft.stockproject.service.ITrackService;

public class TrackService implements ITrackService{

    private TrackDAO tDAO;

    public TrackService() {
	super();
	this.tDAO = new TrackDAO();
    }

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

    @Override
    public void createNewTrack(Track track) {
		
    }
    

}
