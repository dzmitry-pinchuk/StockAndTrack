package com.qaprosoft.stockproject.service;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.stockproject.dao.jdbc.impl.ItemDAO;
import com.qaprosoft.stockproject.entity.Item;

public class ItemService {
    private ItemDAO iDAO;

    public ItemService() {
	super();
	this.iDAO = new ItemDAO();
    }

    public ArrayList<Item> getAll() {
	ArrayList<Item> allItems = iDAO.getAll();
	return allItems;
    }

    public Item getById(Long id) {
	Item item = iDAO.getById(id);
	return item;
    }

    public void deleteById(Long id) {
	iDAO.deleteById(id);
    }

    public Item createNewItem(Item item) {
	return iDAO.createNewItem(item);
    }

    public List<Item> getItemsByStockId(Long id) {
	ArrayList<Item> allItems = iDAO.getItemsByStockId(id);
	return allItems;

    }

}
