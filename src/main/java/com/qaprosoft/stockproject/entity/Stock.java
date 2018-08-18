package com.qaprosoft.stockproject.entity;

import java.util.ArrayList;

public class Stock extends AbstractEntity {

	private String name;
	private ArrayList<StockHasItem> items;
	private ArrayList<TypeOfTransport> types;

//	1 - auto
//	2 - train

	public ArrayList<StockHasItem> getItems() {
		return items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<TypeOfTransport> getTypes() {
		return types;
	}

	public void setTypes(ArrayList<TypeOfTransport> types) {
		this.types = types;
	}

	public void setItems(ArrayList<StockHasItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Stock [ id " + getId() + ", name=" + name + ", types=" + types + ", items=" + items + "]";
	}

}
