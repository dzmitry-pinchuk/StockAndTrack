package com.qaprosoft.stockproject.service;

import java.util.ArrayList;

import com.qaprosoft.stockproject.dao.jdbc.impl.ItemDAO;
import com.qaprosoft.stockproject.dao.jdbc.impl.StockHasItemDAO;
import com.qaprosoft.stockproject.entity.StockHasItem;

public class StockHasItemService {

    private StockHasItemDAO shiDAO;
    private ItemDAO iDAO;

    public StockHasItemService() {
	super();
	this.shiDAO = new StockHasItemDAO();
	this.iDAO = new ItemDAO();
    }

    public ArrayList<StockHasItem> getItemAndQuantityByStockId(Long id) {
	ArrayList<StockHasItem> stockHasItem = shiDAO.getItemAndQuantityByStockId(id);
	for (StockHasItem stockHasItem2 : stockHasItem) {
	    stockHasItem2.setItem(iDAO.getById(stockHasItem2.getItem().getId()));
	}
	return stockHasItem;
    }

    public StockHasItem insertNewItemInStock(Long stockID, StockHasItem shi) {
	shi = shiDAO.insertNewItemInStock(stockID, shi);
	return shi;
    }

    // public void updateItemInStock(Long stockID, StockHasItem shi) {
    // shiDAO.updateItemInStock(stockID, shi);
    // }

    public void updateItemInStock(Long stockID, Long itemId, Integer newCount) {
	shiDAO.updateItemInStock(stockID, itemId, newCount);
    }

    public void deleteItemInStock(StockHasItem shi) {
	shiDAO.deleteItemInStock(shi);
    }

    public Integer getQuantityByStockAndItem(Long itemId, Long stockId) {
	return shiDAO.getQuantityByStockAndItem(itemId, stockId);
    }

    public void insertNewItemInStockByStockItemAndNumber(Long stockID, Long itemId, Integer quantity) {
	shiDAO.insertNewItemInStockByStockItemAndNumber(stockID, itemId, quantity);
    }

    // public void updateItemInStock1(Long stockId, Long itemId, Integer newCount) {
    // shiDAO.updateItemInStock(stockId, itemId, newCount);
    // }

    public void deleteItemByStockIdAndItemId(Long stockId, Long itemId) {
	shiDAO.deleteItemByStockIdAndItemId(stockId, itemId);
    }
}
