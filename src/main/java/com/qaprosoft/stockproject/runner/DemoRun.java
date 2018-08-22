package com.qaprosoft.stockproject.runner;

import java.util.List;

import com.qaprosoft.stockproject.dao.jdbc.impl.StockHasItemDAO;
import com.qaprosoft.stockproject.entity.StockHasItem;
import com.qaprosoft.stockproject.parsing.ClassForJaxB;
import com.qaprosoft.stockproject.parsing.JaxonParser;
import com.qaprosoft.stockproject.service.impl.ItemService;
import com.qaprosoft.stockproject.service.impl.StockHasItemService;
import com.qaprosoft.stockproject.service.impl.StockService;

public class DemoRun {

	public static void main(String[] args) {
		System.out.println("Hello world");

		JaxonParser jp = new JaxonParser();
		jp.writeToJson();
		System.out.println("all done");
		
		

	}

}
