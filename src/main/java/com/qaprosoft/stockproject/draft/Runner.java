package com.qaprosoft.stockproject.draft;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.entity.TypeOfTransport;
import com.qaprosoft.stockproject.entity.transport.Train;
import com.qaprosoft.stockproject.service.impl.ItemService;
import com.qaprosoft.stockproject.service.impl.StockService;
import com.qaprosoft.stockproject.service.impl.TrackService;
import com.qaprosoft.stockproject.service.impl.TrainService;

public class Runner {
 private static Logger logger = LogManager.getLogger();
    
    public static void main(String[] args) {
	StockService stockService = new StockService();
	TrainService trainService = new TrainService();
	TrainService trackService = new TrainService();

	Train train = new Train();
	Train train1 = new Train();
	Train train2 =trainService.getById((long) 1);
	

	train.setType(TypeOfTransport.FOR_TRACK);
	train1.setType(TypeOfTransport.FOR_TRACK);
	train.setMaxCarryingCapacity(30);

	Stock stock1 = new Stock();
	stock1 = stockService.getById((long) 1);

	Stock stock2 = new Stock();
	stock2 = stockService.getById((long) 2);
	System.out.println(stock1);
	logger.info(stock1);

	List<Item> items = new ArrayList<>();

	items.add(new Item("Table", 1, 600));
	items.add(new Item("Umbrella", 2, 5000));
	items.add(new Item("Cat", 4, 1500));
	items.add(new Item("Ball", 2, 40000));
	items.add(new Item("Chair", 1, 5000));
	items.add(new Item("Check", 2, 700));
	items.add(new Item("Rabbit", 4, 5000));
	items.add(new Item("Phone", 1, 500));
	

	AlgorithmforBestLoadUsingRecursion algforBestLoadUsRec = new AlgorithmforBestLoadUsingRecursion();
	List<Item> BestItemLoad = algforBestLoadUsRec.getBestItemLoad(items, train.getMaxCarryingCapacity());
	Integer bestLoadPrice = algforBestLoadUsRec.getBestLoadPrice();

	logger.info("AlgorithmforBestLoadUsingRecursion is used for small amount of subjects");

	logger.info(BestItemLoad);
	logger.info(bestLoadPrice);

	ItemService itemService = new ItemService();
	List<Item> items1 = itemService.getItemsByStockId((long) 1);

	logger.info("AlgorithmforBestLoad is used for any amount of subjects but it'hard to understand");

	AlgorithmforBestLoad algorithmforBestLoad = new AlgorithmforBestLoad();
	List<Item> bestItemLoad1 = algorithmforBestLoad.getBestItemLoad(items1, train.getMaxCarryingCapacity());
	Integer bestLoadPrice1 = algorithmforBestLoad.getBestLoadPrice();
	logger.info(bestItemLoad1);
	logger.info(bestLoadPrice1);

	logger.info("BIG CHECK");
	logger.info(stock1);
	logger.info(stock2);
	logger.info(train2);
	
	TransportBestLoadItemsServiceCopy transportBestLoadItemsService = new TransportBestLoadItemsServiceCopy();
	transportBestLoadItemsService.trasportItems((long)1,(long) 1, (long)1);
	
	logger.info(stock1);
	logger.info(stock2);
	logger.info(train2);

	// TransportBestLoadItemsServiceCopy transportBestLoadItemsServiceCopy = new
	// TransportBestLoadItemsServiceCopy();
	// logger.info(transportBestLoadItemsServiceCopy.checktrasportforstock(stock1.getId(),
	// stock2.getId(), (long) 1));

    }

}
