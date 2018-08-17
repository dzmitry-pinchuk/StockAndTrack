package com.qaprosoft.stockproject.dao;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.StockHasItem;

public interface IStockHasItemDAO {
	
	public ArrayList<StockHasItem> getItemAndQuantityByStockId(Long id);
	
	public StockHasItem insertNewItemInStock(StockHasItem shi);
	
	public void updateItemInStock(StockHasItem shi);

	public void deleteItemInStock(StockHasItem shi);
	
}
