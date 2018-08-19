package com.qaprosoft.stockproject.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.entity.TypeOfTransport;
import com.qaprosoft.stockproject.entity.transport.AbstractTransport;
import com.qaprosoft.stockproject.entity.transport.Train;
import com.qaprosoft.stockproject.service.ItemService;
import com.qaprosoft.stockproject.service.StockService;

public class TestAlg {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
	    
	    StockService stockService = new StockService();

		List<Item> items = new ArrayList<>();
		Train train = new Train();
		Train train1 = new Train();
		Stock stock1 = new Stock();
		stock1 = stockService.getByID((long) 1);
		train.setType(TypeOfTransport.FOR_TRACK);
		train1.setType(TypeOfTransport.FOR_TRACK);
		train.setMaxCarryingCapacity(8);
		items.add(new Item("Table", 1, 600));
		items.add(new Item("Umbrella", 2, 5000));
		items.add(new Item("Cat", 4, 1500));
		items.add(new Item("Ball", 2, 40000));
		items.add(new Item("Chair", 1, 500));

		logger.info("1");
		logger.info(stock1);

		AlgorithmforBestLoad algorithmforBestLoad = new AlgorithmforBestLoad();

		//algorithmforBestLoad.makeAllSets(items, train);
		logger.info(algorithmforBestLoad.getBestLoadPrice());		
		//List<Item> solve = algorithmforBestLoad.getBestItemLoad(items, train);
		//System.out.println(solve);

		List <TypeOfTransport> list = stock1.getTypes();
		//пройтись по списку 

//    public boolean checktrasportforstock(Stock stock1, AbstractTransport transport) {
//		    List <TypeOfTransport> list = stock1.getTypes();
//		  
//		      for (TypeOfTransport : list) {
//		if (transport.getType()==(list.)) {
//		    System.out.println("Good");
//		}
//		
//		else  {
//		    System.out.println(train.getType());
//		    System.out.println(train1.getType());
//		    
//		}
//		
		
		ItemService itemService = new ItemService();
		
	
		
		
		
	}

}
