package com.qaprosoft.entity;

public class StockHasItems extends AbstractEntity{
	
	private Item item;
	private int quantity;
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "StockHasItems [ id " + getId() + ", item=" + item + ", quantity=" + quantity + "]";
	}
	
}
