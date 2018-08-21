package com.qaprosoft.stockproject.demo;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Report;
import com.qaprosoft.stockproject.logic.TransportBestLoadItemsService;

public class DemoLogic {
	
	private static final Logger logger = LogManager.getLogger();
	
	public static void baseLogic(Report report) {
		
		List<Item> usedItems = null;

		TransportBestLoadItemsService tblis = new TransportBestLoadItemsService();
		
		if (tblis.checkTrasportForStock(report)) {
			System.out.println("22222");
			usedItems = tblis.transportItems(report);
			System.out.println("44444");
		} else {
			throw new UnsupportedOperationException("This transport can not usen in this stock");
		}
		logger.log(Level.INFO, "begin work baseLogic");
		report.setItems(usedItems);
		DemoMethod.changeQuantity(report);
		
		int tempPrice = 0;
		for (Item item : usedItems) {
			tempPrice = tempPrice + item.getPrice();
		}
		report.setMaxPrice(tempPrice);
		logger.log(Level.INFO, "Price of item in transport:");
		logger.log(Level.INFO, "Items in transport:");
		logger.log(Level.INFO, report);
		logger.log(Level.INFO, "All operations completed");

	}

}
