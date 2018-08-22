package com.qaprosoft.stockproject.entity;

import java.util.List;

import com.qaprosoft.stockproject.entity.transport.AbstractTransport;

public class Report {
	
	private Stock stockFrom;
	private Stock stockTo;
	private int maxPrice;
	private AbstractTransport transport;
	private List<Item> items;
	
	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Stock getStockFrom() {
		return stockFrom;
	}
	
	public void setStockFrom(Stock stockFrom) {
		this.stockFrom = stockFrom;
	}
	
	public Stock getStockTo() {
		return stockTo;
	}
	
	public void setStockTo(Stock stockTo) {
		this.stockTo = stockTo;
	}
	
	public AbstractTransport getTransport() {
		return transport;
	}
	
	public void setTransport(AbstractTransport transport) {
		this.transport = transport;
	}
	
	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Report [stock1=" + stockFrom + ", stock2=" + stockTo + ", maxPrice=" + maxPrice + ", transport=" + transport
				+ ", items=" + items + "]";
	}
	
}
