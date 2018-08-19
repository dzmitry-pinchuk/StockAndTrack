package com.qaprosoft.stockproject.runner;

import java.util.List;

import com.qaprosoft.stockproject.dao.jdbc.impl.StockHasItemDAO;
import com.qaprosoft.stockproject.entity.StockHasItem;
import com.qaprosoft.stockproject.parsing.ClassForJaxB;
import com.qaprosoft.stockproject.parsing.JaxonParser;
import com.qaprosoft.stockproject.service.ItemService;
import com.qaprosoft.stockproject.service.StockHasItemService;
import com.qaprosoft.stockproject.service.StockService;

public class DemoRun {

    public static void main(String[] args) {
	System.out.println("Hello world");

	// JaxonParser jp = new JaxonParser();
	// jp.writeToJson();
	// System.out.println("all done");
	StockService ss = new StockService();
	ItemService ssww = new ItemService();
	System.out.println(ssww.getById((long) 1));
	// ClassForJaxB temp = new ClassForJaxB();
	// System.out.println(temp);
	StockHasItemDAO stockHasItemDAO = new StockHasItemDAO();

	//List<StockHasItem> stockHasItem1 = stockHasItemDAO.getItemAndQuantityByStockId((long) 1);

	    StockHasItemService stockHasItemService = new StockHasItemService();

	    List<StockHasItem> stockHasItem1 = stockHasItemService.getItemAndQuantityByStockId((long) 1);
	System.out.println(stockHasItem1);
	
	// StockService ss = new StockService();
	// System.out.println(ss.getByID((long) 1));

	// List <StockHasItem> items =
	// stockHasItemDAO.getItemAndQuantityByStockId((long) 1);
    }

}
