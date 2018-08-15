package com.qaprosoft.dao;

import java.util.ArrayList;

import com.qaprosoft.entity.transport.AbstractTransport;

public interface ITransportDAO {
	
public ArrayList<AbstractTransport> getAll();
	
	public AbstractTransport getById(Long id);
	
	public void deleteById(Long id);
	
	public void createNewTrack(AbstractTransport transport);

}
