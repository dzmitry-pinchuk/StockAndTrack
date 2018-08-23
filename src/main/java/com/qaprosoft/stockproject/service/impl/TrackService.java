package com.qaprosoft.stockproject.service.impl;

import java.util.List;

import com.qaprosoft.stockproject.dao.jdbc.impl.TrackDAO;
import com.qaprosoft.stockproject.entity.transport.Track;
import com.qaprosoft.stockproject.service.IDefaultService;

public class TrackService implements IDefaultService<Long, Track> {

	private TrackDAO tDAO;

	public TrackService() {
		super();
		this.tDAO = new TrackDAO();
	}

	public List<Track> getAll() {
		return tDAO.getAll();
	}

	public Track getById(Long id) {
		Track track = tDAO.getById(id);
		return track;
	}

	public void deleteById(Long id) {
		tDAO.deleteById(id);
	}

	@Override
	public void createNewEntity(Track entity) {
		// TODO Auto-generated method stub

	}

}
