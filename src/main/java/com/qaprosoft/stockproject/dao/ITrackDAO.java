package com.qaprosoft.stockproject.dao;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.transport.Track;

public interface ITrackDAO {

	public ArrayList<Track> getAll();

	public Track getById(Long id);

	public void deleteById(Long id);

	public void createNewTrack(Track track);

}
