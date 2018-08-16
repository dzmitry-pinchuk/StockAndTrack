package com.qaprosoft.stockproject.dao;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.transport.Train;

public interface ITrainDAO {
	
public ArrayList<Train> getAll();
	
	public Train getById(Long id);
	
	public void deleteById(Long id);
	
	public void createNewTrack(Train train);

}
