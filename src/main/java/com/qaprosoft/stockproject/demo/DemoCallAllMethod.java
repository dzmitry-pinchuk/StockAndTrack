package com.qaprosoft.stockproject.demo;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Report;
import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.entity.transport.Track;
import com.qaprosoft.stockproject.entity.transport.Train;
import com.qaprosoft.stockproject.parsing.ClassForJaxB;

public class DemoCallAllMethod {
	
	private static final Logger logger = LogManager.getLogger();
	private Scanner scan = new Scanner(System.in);

	public void start() {
		
		Report report = new Report();
		ClassForJaxB all = new ClassForJaxB();
		ArrayList<Stock> stocks = all.getStocks();
		ArrayList<Track> tracks = all.getTracks();
		ArrayList<Train> trains = all.getTrains();	
		
		logger.log(Level.INFO, "DataBase has Stocks: ");
		
		logger.log(Level.INFO, stocks);
		logger.log(Level.INFO, "Insert StockID first(1 - " + stocks.size() + "): ");
		Long stockID1 = scan.nextLong();
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getId() == stockID1) {
				report.setStock1(stocks.get(i));
			}
		}

		logger.log(Level.INFO, "Insert StockID second(1 - " + stocks.size() + "): ");
		Long stockID2 = scan.nextLong();
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getId() == stockID2) {
				report.setStock1(stocks.get(i));
			}
		}
		
		if ( stockID1<0 || stockID1>stocks.size() ||  stockID2<0 || stockID2>stocks.size()) {
			throw new UnsupportedOperationException("You must insert correct value. Try again");
		}
		
		logger.log(Level.INFO, "Select type of transport(1 - auto, 2 - train): ");
		int type = scan.nextInt();
		if ( type < 1 || type > 2 ) {
			throw new UnsupportedOperationException("You must insert correct value. Try again");
		}
		switch (type) {
		case 1:
			logger.log(Level.INFO, tracks);
			logger.log(Level.INFO, "Insert TransportID(1 - " + tracks.size() + "): ");
			int trackID = scan.nextInt();
			for (int i = 0; i < tracks.size(); i++) {
				if (tracks.get(i).getId() == trackID) {
					report.setTransport(tracks.get(i));
				}
			}		
			break;
		case 2:
			logger.log(Level.INFO, trains);
			logger.log(Level.INFO, "Insert TransportID(1 - " + trains.size() + "): ");
			int trainID = scan.nextInt();
			for (int i = 0; i < trains.size(); i++) {
				if (trains.get(i).getId() == trainID) {
					report.setTransport(trains.get(i));
				}
			}		
			break;
		}
	}
}
