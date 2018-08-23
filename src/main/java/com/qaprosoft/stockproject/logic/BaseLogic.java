package com.qaprosoft.stockproject.logic;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.algorithm.AlgorithmforBestLoad;
import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Report;
import com.qaprosoft.stockproject.entity.TypeOfTransport;
import com.qaprosoft.stockproject.service.impl.ItemService;

public class BaseLogic {

	private static final Logger logger = LogManager.getLogger();
	private static ItemService itemService = new ItemService();

	public static void baseLogic(Report report) {

		List<Item> usedItems = null;

		if (checkTrasportForStock(report)) {
			List<Item> items = itemService.getItemsByStockId(report.getStockFrom().getId());
			usedItems = AlgorithmforBestLoad.getBestItemLoad(items, report.getTransport().getMaxCarryingCapacity());
		} else {
			throw new UnsupportedOperationException("This transport can not used in this stock");
		}
		logger.log(Level.INFO, "begin work baseLogic");
		report.setItems(usedItems);
		QuantityChanger.changeQuantity2(report);

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

	public static boolean checkTrasportForStock(Report report) {
		TypeOfTransport typeOfTransport = report.getTransport().getType();
		List<TypeOfTransport> list1 = report.getStockFrom().getTypes();
		List<TypeOfTransport> list2 = report.getStockTo().getTypes();
		return list1.contains(typeOfTransport) && list2.contains(typeOfTransport);
	}

}
