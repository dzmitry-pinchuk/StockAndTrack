package com.qaprosoft.stockproject.service.impl;

import java.util.ArrayList;

import com.qaprosoft.stockproject.dao.jdbc.impl.TrainDAO;
import com.qaprosoft.stockproject.entity.transport.Train;
import com.qaprosoft.stockproject.service.ITrainService;

public class TrainService implements ITrainService {

    private TrainDAO trDAO;

      public TrainService() {
	super();
	this.trDAO = new TrainDAO();
    }

    @Override
    public ArrayList<Train> getAll() {
	ArrayList<Train> allTrains = trDAO.getAll();
	return allTrains;
    }

    @Override
    public Train getById(Long id) {
	Train train = trDAO.getById(id);
	return train;
    }

    @Override
    public void deleteById(Long id) {
	trDAO.deleteById(id);
    }

}
