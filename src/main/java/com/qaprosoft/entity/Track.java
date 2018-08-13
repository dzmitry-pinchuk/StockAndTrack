package com.qaprosoft.entity;

public class Track extends AbstractEntity{
	
	private int maxVolume;
	private int maxPrice;
	private String name;
	private int type;
//	1 - auto
//	2 - train
//	3 - all
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getMaxVolume() {
		return maxVolume;
	}
	public void setMaxVolume(int maxVolume) {
		this.maxVolume = maxVolume;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	@Override
	public String toString() {
		return "Track [ id " + getId() + ",  name= " + name + ", maxVolume=" + maxVolume + ", maxPrice=" + maxPrice + ", type=" + type + "]";
	}
	
	

}
