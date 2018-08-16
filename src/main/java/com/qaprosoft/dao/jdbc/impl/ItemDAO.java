package com.qaprosoft.dao.jdbc.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.dao.IItemDAO;
import com.qaprosoft.entity.Item;

public class ItemDAO implements IItemDAO {
	
	private static Logger logger = LogManager.getLogger();
	
	public static final String SQL_SELECT_ALL_ITEMS = "SELECT * FROM sat.items";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM sat.items WHERE id=?";
	public static final String SQL_DELETE_BY_ID = "DELETE FROM sat.items WHERE id = ?";
	public static final String SQL_CREATE_NEW_ITEM = "INSERT INTO sat.items (`name`, `price`, `weight`) VALUES (?,?,?)";	

	@Override
	public ArrayList<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createNewItem(Item item) {
		// TODO Auto-generated method stub
		
	}

}
