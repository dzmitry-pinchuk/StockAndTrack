package com.qaprosoft.stockproject.entity;

public class StockHasItem extends AbstractEntity{
	
	private Stock stock;
	private Item item;
	private Integer quantity;
	
	public Stock getStock() {
		return stock;
	}
	
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "StockHasItem [stock=" + stock + ", item=" + item + ", quantity=" + quantity + "]";
	}
	
	
	

}
