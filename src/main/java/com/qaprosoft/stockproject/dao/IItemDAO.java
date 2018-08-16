package com.qaprosoft.dao;

import java.util.ArrayList;

import com.qaprosoft.entity.Item;

public interface IItemDAO {
	
	public ArrayList<Item> getAll();
	
	public Item getById(Long id);
	
	public void deleteById(Long id);
	
	public void createNewItem(Item item);
	

}
