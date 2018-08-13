package com.qaprosoft.dao;

import java.util.ArrayList;

import com.qaprosoft.entity.Stock;
import com.qaprosoft.entity.StockHasItems;

public interface IStockHasItemsDAO {
	
	public ArrayList<StockHasItems> getAll();
	
	public StockHasItems getById(Long id);
	
	public void deleteById(Long id);
	
	public void createNewStockHasItems(StockHasItems stockHasItems);
	
	public StockHasItems getStockHasItemsBtStockId(Stock stock);

}
