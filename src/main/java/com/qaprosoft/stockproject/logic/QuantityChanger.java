package com.qaprosoft.stockproject.logic;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Report;
import com.qaprosoft.stockproject.service.impl.StockHasItemService;

public class QuantityChanger {

	private static final Logger logger = LogManager.getLogger();

	public static void changeQuantity(Report report) {
		StockHasItemService stockHasItemService = new StockHasItemService();
		List<Item> bestLoadList = report.getItems();
		for (Item item : bestLoadList) {
			// update in fromStock
			Integer fromCount = stockHasItemService.getQuantityByStockAndItem(item.getId(),
					report.getStockFrom().getId());
			if (fromCount == 1) {
				stockHasItemService.deleteItemByStockIdAndItemId(report.getStockFrom().getId(), item.getId());
				logger.log(Level.INFO, "Entry in DataBase was deleted");
			} else if (fromCount > 1) {
				stockHasItemService.updateItemInStock(report.getStockFrom().getId(), item.getId(), fromCount - 1);
				logger.log(Level.INFO, "Entry in DataBase was change");
			}
			// update in toStock
			Integer toCount = stockHasItemService.getQuantityByStockAndItem(item.getId(), report.getStockTo().getId());
			if (toCount == null) {
				stockHasItemService.insertNewItemInStockByStockItemAndNumber(report.getStockTo().getId(), item.getId(),
						1);
				logger.log(Level.INFO, "Create new entry in DataBase");
			} else {
				stockHasItemService.updateItemInStock(report.getStockTo().getId(), item.getId(), toCount + 1);
				logger.log(Level.INFO, "Entry in DataBase was change");
			}
		}

	}

}
