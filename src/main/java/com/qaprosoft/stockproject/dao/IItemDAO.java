package com.qaprosoft.stockproject.dao;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.Item;

public interface IItemDAO {
	
	public ArrayList<Item> getAll();
	
	public Item getById(Long id);
	
	public void deleteById(Long id);
	
	public Item createNewItem(Item item);
	

}
