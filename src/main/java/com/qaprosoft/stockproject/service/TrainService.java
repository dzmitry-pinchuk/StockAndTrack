package com.qaprosoft.stockproject.service;

import java.util.ArrayList;

import com.qaprosoft.stockproject.dao.jdbc.impl.TrainDAO;
import com.qaprosoft.stockproject.entity.transport.Train;

public class TrainService {

	private TrainDAO trDAO = new TrainDAO();

	public ArrayList<Train> getAll() {
		ArrayList<Train> allTrains = trDAO.getAll();
		return allTrains;
	}

	public Train getById(Long id) {
		Train train = trDAO.getById(id);
		return train;
	}

	public void deleteById(Long id) {
		trDAO.deleteById(id);
	}
	
	
	
}
