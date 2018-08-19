package com.qaprosoft.stockproject.demo;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.StockHasItem;
import com.qaprosoft.stockproject.service.StockHasItemService;

public class DemoMethod {

	private static final Logger logger = LogManager.getLogger();
	
	public void changeQuantity(Long stockId1, Long stockId2, ArrayList<Item> usedItems) { //usedItems - лист вещей, которые загрузили в транспорт
		StockHasItemService shis = new StockHasItemService();
		ArrayList<StockHasItem> itemByStockID1 = shis.getItemAndQuantityByStockId(stockId1);
		for (int i=0; i<usedItems.size(); i++) {
			for (int j=0; j<itemByStockID1.size(); j++) {
				if (usedItems.contains(itemByStockID1.get(j).getItem())) {
					switch (itemByStockID1.get(j).getQuantity()) {
					case 1:
						shis.deleteItemInStock(itemByStockID1.get(j));
						logger.log(Level.INFO, "Entry in DataBase was deleted");
						break;
					default:
						int tempQuantity = itemByStockID1.get(j).getQuantity()-1;
						itemByStockID1.get(j).setQuantity(tempQuantity);
						shis.updateItemInStock(stockId1, itemByStockID1.get(j));
						logger.log(Level.INFO, "Entry in DataBase was updated");
						break;
					}
				}
			}
		}
		
		ArrayList<StockHasItem> itemByStockID2 = shis.getItemAndQuantityByStockId(stockId2);
		for (int i = 0; i < usedItems.size(); i++) {
			for (int j=0; j<itemByStockID2.size(); j++) {
				if (usedItems.contains(itemByStockID2.get(j).getItem())) {
					int tempQuantity = itemByStockID2.get(j).getQuantity()+1;
					itemByStockID2.get(j).setQuantity(tempQuantity);
					shis.updateItemInStock(stockId2, itemByStockID2.get(j));
					logger.log(Level.INFO, "Entry in DataBase was change");
				} else {
					StockHasItem shi = new StockHasItem();
					shi.setItem(usedItems.get(i));
					shi.setQuantity(1);
					shis.insertNewItemInStock(stockId2, shi);
					logger.log(Level.INFO, "Create new entry in DataBase");
				}
			}
		}
		
		
		
		
	}
	
}
