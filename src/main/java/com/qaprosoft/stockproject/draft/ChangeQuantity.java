package com.qaprosoft.stockproject.draft;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Report;
import com.qaprosoft.stockproject.entity.StockHasItem;
import com.qaprosoft.stockproject.service.impl.StockHasItemService;

public class ChangeQuantity {
	
	private static final Logger logger = LogManager.getLogger();

	public static void changeQuantity(Report report) { // not used
		StockHasItemService shis = new StockHasItemService();
		List<Item> usedItems = report.getItems();
		List<StockHasItem> itemByStockID1 = shis.getItemAndQuantityByStockId(report.getStockFrom().getId());
		for (int i = 0; i < usedItems.size(); i++) {
			for (int j = 0; j < itemByStockID1.size(); j++) {
				if (usedItems.contains(itemByStockID1.get(j).getItem())) {
					switch (itemByStockID1.get(j).getQuantity()) {
					case 1:
						shis.deleteItemInStock(itemByStockID1.get(j));
						logger.log(Level.INFO, "Entry in DataBase was deleted");
						break;
					default:
						int tempQuantity = itemByStockID1.get(j).getQuantity() - 1;
						itemByStockID1.get(j).setQuantity(tempQuantity);
						shis.updateItemInStock(report.getStockFrom().getId(), itemByStockID1.get(j).getItem().getId(),
								tempQuantity);
						logger.log(Level.INFO, "Entry in DataBase was updated");
						break;
					}
				}
			}
		}

		List<StockHasItem> itemByStockID2 = shis.getItemAndQuantityByStockId(report.getStockFrom().getId());
		for (int i = 0; i < usedItems.size(); i++) {
			for (int j = 0; j < itemByStockID2.size(); j++) {
				if (usedItems.contains(itemByStockID2.get(j).getItem())) {
					int tempQuantity = itemByStockID2.get(j).getQuantity() + 1;
					itemByStockID2.get(j).setQuantity(tempQuantity);
					shis.updateItemInStock(report.getStockTo().getId(), itemByStockID2.get(j).getItem().getId(),
							tempQuantity);
					logger.log(Level.INFO, "Entry in DataBase was change");
				} else {
					StockHasItem shi = new StockHasItem();
					shi.setItem(usedItems.get(i));
					shi.setQuantity(1);
					shis.insertNewItemInStock(report.getStockTo().getId(), shi);
					logger.log(Level.INFO, "Create new entry in DataBase");
				}
			}
		}
	}
}
