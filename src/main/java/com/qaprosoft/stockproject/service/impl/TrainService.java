package com.qaprosoft.stockproject.service.impl;

import java.util.List;

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
	public List<Train> getAll() {
		return trDAO.getAll();
	}

	@Override
	public Train getById(Long id) {
		return trDAO.getById(id);

	}

	@Override
	public void deleteById(Long id) {
		trDAO.deleteById(id);
	}

	@Override
	public void createNewEntity(Train entity) {
		throw new UnsupportedOperationException("method not create");
	}

}
