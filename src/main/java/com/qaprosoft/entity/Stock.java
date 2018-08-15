package com.qaprosoft.entity;

import java.util.ArrayList;

public class Stock extends AbstractEntity {

	private ArrayList<Item> items;
	private TypeOfTransport type;
	
//	1 - auto
//	2 - train
//	3 - all
	
	public TypeOfTransport getType() {
		return type;
	}
	
	public void setType(TypeOfTransport type) {
		this.type = type;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Stock [ id " + getId() + ", type=" + type + ", items=" + items + "]";
	}

}
