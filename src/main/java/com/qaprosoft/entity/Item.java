package com.qaprosoft.entity;

public class Item extends AbstractEntity{
	
	private String name;
	private int volume;
	private int price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [ id " + getId() + ", name=" + name + ", volume=" + volume + ", price=" + price + "]";
	}
	
	

}
