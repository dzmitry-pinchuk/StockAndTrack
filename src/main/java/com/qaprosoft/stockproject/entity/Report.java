package com.qaprosoft.stockproject.entity;

import java.util.List;

import com.qaprosoft.stockproject.entity.transport.AbstractTransport;

public class Report {
	
	private Stock stock1;
	private Stock stock2;
	private int maxPrice;
	private AbstractTransport transport;
	private List<Item> items;
	
	public int getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Stock getStock1() {
		return stock1;
	}
	
	public void setStock1(Stock stock1) {
		this.stock1 = stock1;
	}
	
	public Stock getStock2() {
		return stock2;
	}
	
	public void setStock2(Stock stock2) {
		this.stock2 = stock2;
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
		return "Report [stock1=" + stock1 + ", stock2=" + stock2 + ", maxPrice=" + maxPrice + ", transport=" + transport
				+ ", items=" + items + "]";
	}
	
}
