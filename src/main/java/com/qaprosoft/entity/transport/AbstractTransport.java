package com.qaprosoft.entity.transport;

import com.qaprosoft.entity.AbstractEntity;

public abstract class AbstractTransport extends AbstractEntity {
	
	private int maxVolume;
	private int maxPrice;
	private String name;
	private int type;
//	1 - auto
//	2 - train
//	3 - all
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
	@Override
	public String toString() {
		return "AbstractTransport [ id= " + getId() + ", maxVolume=" + maxVolume + ", maxPrice=" + maxPrice + ", name=" + name + ", type="
				+ type + "]";
	}

	
}
