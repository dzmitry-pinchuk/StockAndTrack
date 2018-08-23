package com.qaprosoft.stockproject.draft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.service.impl.StockHasItemService;
import com.qaprosoft.stockproject.service.impl.StockService;
import com.qaprosoft.stockproject.service.impl.TrainService;

public class Runner2 {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
	
	StockService stockService = new StockService();
	TrainService trainService = new TrainService();
	StockHasItemService stockHasItemService = new StockHasItemService();
	long a =1;
	long b =2;
	Integer iiu=stockHasItemService.getQuantityByStockAndItem(a, b);
	logger.info(iiu);
	//stockHasItemService.getQuantityByStockAndItem(item.getId(), fromIdStock);
	
	Stock stock1 = new Stock();
	stock1 = stockService.getById((long) 1);

	Stock stock2 = new Stock();
	stock2 = stockService.getById((long) 2);
	System.out.println(stock1);
	logger.info(stock2);
	
	StockHasItemService stockHasItemService1 = new StockHasItemService();
	long a1 =1;
	long b1 =2;
	Integer bb =1;
	stockHasItemService1.updateItemInStock(a1, b1, bb);
	
	TransportBestLoadItemsServiceCopy transportBestLoadItemsService = new TransportBestLoadItemsServiceCopy();
	//transportBestLoadItemsService.checktrasportforstock((long)1,(long) 2, (long)1);
	transportBestLoadItemsService.trasportItems((long)1,(long) 2, (long)1);
	
	
	
    }

}
