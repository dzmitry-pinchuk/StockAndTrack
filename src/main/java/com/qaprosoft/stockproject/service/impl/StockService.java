package com.qaprosoft.stockproject.service.impl;

import java.util.List;

import com.qaprosoft.stockproject.dao.jdbc.impl.ItemDAO;
import com.qaprosoft.stockproject.dao.jdbc.impl.StockDAO;
import com.qaprosoft.stockproject.dao.jdbc.impl.StockHasItemDAO;
import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.entity.StockHasItem;
import com.qaprosoft.stockproject.service.IStockService;

public class StockService implements IStockService {

	private StockDAO sDAO;
	private StockHasItemDAO shiDAO;
	private ItemDAO iDAO;

	public StockService() {
		super();
		this.sDAO = new StockDAO();
		this.shiDAO = new StockHasItemDAO();
		this.iDAO = new ItemDAO();
	}

	@Override
	public Stock getById(Long id) {
		Stock stock = sDAO.getById(id);
		List<StockHasItem> items = shiDAO.getItemAndQuantityByStockId(id);
		for (StockHasItem stockHasItem : items) {
			Item item = iDAO.getById(stockHasItem.getItem().getId());
			stockHasItem.setItem(item);
		}
		stock.setItems(items);
		return stock;
	}

	@Override
	public List<Stock> getAll() {
		List<Stock> allStocks = sDAO.getAll();
		for (Stock stock : allStocks) {
			List<StockHasItem> items = shiDAO.getItemAndQuantityByStockId(stock.getId());
			for (StockHasItem stockHasItem : items) {
				Item item = iDAO.getById(stockHasItem.getItem().getId());
				stockHasItem.setItem(item);
			}
			stock.setItems(items);
		}
		return allStocks;
	}

	@Override
	public void deleteById(Long id) {
		throw new UnsupportedOperationException("method not create");

	}

	@Override
	public void createNewEntity(Stock entity) {
		throw new UnsupportedOperationException("method not create");

	}

}
