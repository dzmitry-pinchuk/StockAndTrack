package com.qaprosoft.stockproject.entity;

import java.util.ArrayList;

public class Stock extends AbstractEntity {

	private ArrayList<StockHasItem> items;
	private ArrayList<TypeOfTransport> types;

//	1 - auto
//	2 - train

	public ArrayList<StockHasItem> getItems() {
		return items;
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
		return "Stock [ id " + getId() + ", types=" + types + ", items=" + items + "]";
	}

}
