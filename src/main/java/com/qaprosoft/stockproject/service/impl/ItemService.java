package com.qaprosoft.stockproject.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.stockproject.dao.jdbc.impl.ItemDAO;
import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.service.IItemService;

public class ItemService implements IItemService {
	private ItemDAO iDAO;

	public ItemService() {
		super();
		this.iDAO = new ItemDAO();
	}

	@Override
	public List<Item> getAll() {
		List<Item> allItems = iDAO.getAll();
		return allItems;
	}

	@Override
	public Item getById(Long id) {
		Item item = iDAO.getById(id);
		return item;
	}

	@Override
	public void deleteById(Long id) {
		iDAO.deleteById(id);
	}

	@Override
	public List<Item> getItemsByStockId(Long id) {
		ArrayList<Item> allItems = iDAO.getItemsByStockId(id);
		return allItems;

	}

	@Override
	public void createNewEntity(Item entity) {
	   	    
	}

}
