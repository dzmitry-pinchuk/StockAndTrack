package com.qaprosoft.stockproject.service;

import java.util.ArrayList;

import com.qaprosoft.stockproject.dao.jdbc.impl.StockHasItemDAO;
import com.qaprosoft.stockproject.entity.StockHasItem;

public class StockHasItemService {
	
	private StockHasItemDAO shiDAO = new StockHasItemDAO();
	
	public ArrayList<StockHasItem> getItemAndQuantityByStockId(Long id) {
		ArrayList<StockHasItem> stockHasItem = shiDAO.getItemAndQuantityByStockId(id);
		
		
		
		
		return stockHasItem;
	}
	
	public StockHasItem insertNewItemInStock(StockHasItem shi) {
		shi = shiDAO.insertNewItemInStock(shi);
		return shi;
	}
	
	public void updateItemInStock(StockHasItem shi) {
		shiDAO.updateItemInStock(shi);
	}
	
	public void deleteItemInStock(StockHasItem shi) {
		shiDAO.deleteItemInStock(shi);
	}
}
