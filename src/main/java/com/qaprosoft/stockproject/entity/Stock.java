package com.qaprosoft.stockproject.entity;

import java.util.List;

public class Stock extends AbstractEntity {

	private String name;
	private List<StockHasItem> items;
	private List<TypeOfTransport> types;

//	1 - auto
//	2 - train

	public List<StockHasItem> getItems() {
		return items;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TypeOfTransport> getTypes() {
		return types;
	}

	public void setTypes(List<TypeOfTransport> types) {
		this.types = types;
	}

	public void setItems(List<StockHasItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "\n Stock [ id= " + getId() + ", name=" + name + ", types=" + types + ", items=" + items + "] ";
	}

}
