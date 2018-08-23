package com.qaprosoft.stockproject.logic;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Report;
import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.entity.transport.Track;
import com.qaprosoft.stockproject.entity.transport.Train;
import com.qaprosoft.stockproject.parsing.ClassForJaxB;

public class CallAllMethod {

	private static final Logger logger = LogManager.getLogger();
	private static Scanner scan = new Scanner(System.in);

	public static void makeMagic() {

		Report report = new Report();
		ClassForJaxB all = new ClassForJaxB(1);
		List<Stock> stocks = all.getStocks();
		List<Track> tracks = all.getTracks();
		List<Train> trains = all.getTrains();


		logger.log(Level.INFO, "DataBase has Stocks: ");

		logger.log(Level.INFO, stocks);
		logger.log(Level.INFO, "Insert StockID first(1 - " + stocks.size() + "): ");
		Long stockID1 = scan.nextLong();
		for (Stock stock : stocks) {
			if (stock.getId() == stockID1) {
				report.setStockFrom(stock);
			}
		}

		logger.log(Level.INFO, "Insert StockID second(1 - " + stocks.size() + "): ");
		Long stockID2 = scan.nextLong();
		
		for (Stock stock : stocks) {
			if (stock.getId() == stockID2) {
				report.setStockTo(stock);
			}
		}

		if (stockID1 < 0 || stockID1 > stocks.size() || stockID2 < 0 || stockID2 > stocks.size()
				|| stockID1 == stockID2) {
			throw new UnsupportedOperationException("You must insert correct value. Try again");
		}

		logger.log(Level.INFO, "Select type of transport(1 - auto, 2 - train): ");
		int type = scan.nextInt();
		if (type < 1 || type > 2) {
			throw new UnsupportedOperationException("You must insert correct value. Try again");
		}
		switch (type) {
		case 1:
			logger.log(Level.INFO, tracks);
			logger.log(Level.INFO, "Insert TransportID(1 - " + tracks.size() + "): ");
			int trackID = scan.nextInt();
			for (Track track : tracks) {
				if (track.getId() == trackID) {
					report.setTransport(track);
				}
			}
			break;
		case 2:
			logger.log(Level.INFO, trains);
			logger.log(Level.INFO, "Insert TransportID(1 - " + trains.size() + "): ");
			int trainID = scan.nextInt();
			for (Train train : trains) {
				if (train.getId() == trainID) {
					report.setTransport(train);
				}
			}
			break;

		}

		BaseLogic.baseLogic(report);
	}
}
