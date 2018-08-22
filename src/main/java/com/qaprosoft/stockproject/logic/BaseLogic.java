package com.qaprosoft.stockproject.logic;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.algorithm.TransportBestLoadItemsService;
import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Report;

public class BaseLogic {
	
	private static final Logger logger = LogManager.getLogger();
	
	public static void baseLogic(Report report) {
		
		List<Item> usedItems = null;

		TransportBestLoadItemsService tblis = new TransportBestLoadItemsService();
		
		if (tblis.checkTrasportForStock(report)) {
			usedItems = tblis.transportItems(report);
		} else {
			throw new UnsupportedOperationException("This transport can not usen in this stock");
		}
		logger.log(Level.INFO, "begin work baseLogic");
		report.setItems(usedItems);
		ChangeQuantity.changeQuantity2(report); 
		
		int tempPrice = 0;
		for (Item item : usedItems) {
			tempPrice = tempPrice + item.getPrice();
		}
		report.setMaxPrice(tempPrice);
		logger.log(Level.INFO, "Price of item in transport: " + tempPrice);
		logger.log(Level.INFO, "Items in transport:");
		logger.log(Level.INFO, report);
		logger.log(Level.INFO, "All operations completed");

	}

}
