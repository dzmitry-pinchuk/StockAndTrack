package com.qaprosoft.stockproject.parsing;

import java.util.List;

import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.entity.transport.Track;
import com.qaprosoft.stockproject.entity.transport.Train;
import com.qaprosoft.stockproject.service.impl.StockService;
import com.qaprosoft.stockproject.service.impl.TrackService;
import com.qaprosoft.stockproject.service.impl.TrainService;

public class AllTable {

	private List<Stock> stocks;
	private List<Track> tracks;
	private List<Train> trains;

	public AllTable() {
	}

	public AllTable(int i) {

		StockService ss = new StockService();
		this.stocks = ss.getAll();

		TrackService ts = new TrackService();
		this.tracks = ts.getAll();

		TrainService trs = new TrainService();
		this.trains = trs.getAll();

	}

	public List<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	@Override
	public String toString() {
		return "ClassForJaxB [stocks=" + stocks + ", tracks=" + tracks + ", trains=" + trains + "]";
	}

}
