package com.qaprosoft.stockproject.parsing;

import java.util.ArrayList;

import com.qaprosoft.stockproject.dao.jdbc.impl.StockDAO;
import com.qaprosoft.stockproject.dao.jdbc.impl.TrackDAO;
import com.qaprosoft.stockproject.dao.jdbc.impl.TrainDAO;
import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.entity.transport.Track;
import com.qaprosoft.stockproject.entity.transport.Train;

public class ClassForJaxB {
	
	private ArrayList<Stock> stocks;
	private ArrayList<Track> tracks;
	private ArrayList<Train> trains;
	
	public ClassForJaxB() {
		StockDAO sDAO = new StockDAO();
		this.stocks = sDAO.getAll();
		
		TrackDAO tDAO = new TrackDAO();
		this.tracks = tDAO.getAll();
		
		TrainDAO trDAO = new TrainDAO();
		this.trains = trDAO.getAll();
		
	}

	public ArrayList<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(ArrayList<Stock> stocks) {
		this.stocks = stocks;
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}

	public ArrayList<Train> getTrains() {
		return trains;
	}

	public void setTrains(ArrayList<Train> trains) {
		this.trains = trains;
	}

	@Override
	public String toString() {
		return "ClassForJaxB [stocks=" + stocks + ", tracks=" + tracks + ", trains=" + trains + "]";
	}
	
	
	

}
