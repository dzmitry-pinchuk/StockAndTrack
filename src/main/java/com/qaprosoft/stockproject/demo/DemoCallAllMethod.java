package com.qaprosoft.stockproject.demo;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Report;
import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.parsing.ClassForJaxB;

public class DemoCallAllMethod {
	
	private static final Logger logger = LogManager.getLogger();
	private Scanner scan = new Scanner(System.in);
	

	public void start() {
		
		Report report = new Report();
		
		ClassForJaxB all = new ClassForJaxB();
		logger.log(Level.INFO, "DataBase has Stocks: ");
		ArrayList<Stock> stocks = all.getStocks();
		logger.log(Level.INFO, stocks);
		logger.log(Level.INFO, "Insert StockID first: ");
		Long stockID1 = scan.nextLong();
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getId() == stockID1) {
				report.setStock1(stocks.get(i));
			}
		}

		logger.log(Level.INFO, "Insert StockID second: ");
		Long stockID2 = scan.nextLong();
		for (int i = 0; i < stocks.size(); i++) {
			if (stocks.get(i).getId() == stockID2) {
				report.setStock1(stocks.get(i));
			}
		}
		
		logger.log(Level.INFO, "Select type of transport(1 - auto, 2 - train): ");
		int type = scan.nextInt();
		switch (type) {
		case 1:
			logger.log(Level.INFO, all.getTracks());
			break;
		case 2:
			logger.log(Level.INFO, all.getTrains());
			break;
		default:
			logger.log(Level.ERROR, "Error. Insert onli 1 or 2");
			break;
		}
		logger.log(Level.INFO, "Insert TransportID: ");
		int transportID = scan.nextInt();
		
	}
}
