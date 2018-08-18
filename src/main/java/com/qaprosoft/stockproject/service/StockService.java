package com.qaprosoft.stockproject.service;

import java.util.ArrayList;

import com.qaprosoft.stockproject.dao.jdbc.impl.ItemDAO;
import com.qaprosoft.stockproject.dao.jdbc.impl.StockDAO;
import com.qaprosoft.stockproject.dao.jdbc.impl.StockHasItemDAO;
import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.entity.StockHasItem;

public class StockService {
	
	private StockDAO sDAO = new StockDAO();
	private StockHasItemDAO shiDAO = new StockHasItemDAO();
	private ItemDAO iDAO = new ItemDAO();
	
	
	public Stock getByID(Long id) {
		Stock stock = sDAO.getById(id);
		ArrayList<StockHasItem> items = shiDAO.getItemAndQuantityByStockId(id);
		for (StockHasItem stockHasItem : items) {
			Item item = iDAO.getById(stockHasItem.getItem().getId());
			stockHasItem.setItem(item);
		}
		stock.setItems(items);	
		return stock;
	}
	
	public ArrayList<Stock> getAllStocks(){
		ArrayList<Stock> allStocks = sDAO.getAll();
		for (Stock stock : allStocks) {
			ArrayList<StockHasItem> items = shiDAO.getItemAndQuantityByStockId(stock.getId());
			for (StockHasItem stockHasItem : items) {
				Item item = iDAO.getById(stockHasItem.getItem().getId());
				stockHasItem.setItem(item);
			}
			stock.setItems(items);	
		}
		return allStocks;
	}
	
	

}
