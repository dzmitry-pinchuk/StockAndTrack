package com.qaprosoft.entity;

import java.util.ArrayList;

public class Stock extends AbstractEntity {

	private ArrayList<StockHasItems> items;
	private int type;
//	1 - auto
//	2 - train
//	3 - all
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public ArrayList<StockHasItems> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<StockHasItems> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Stock [ id " + getId() + ", type=" + type + ", items=" + items + "]";
	}

}
