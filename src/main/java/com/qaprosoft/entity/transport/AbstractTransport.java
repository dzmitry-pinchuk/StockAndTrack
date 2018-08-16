package com.qaprosoft.entity.transport;

import com.qaprosoft.entity.AbstractEntity;
import com.qaprosoft.entity.TypeOfTransport;

public abstract class AbstractTransport extends AbstractEntity {
	
	private Integer maxCarryingCapacity;
	private Integer maxPrice;
	private String name;
	private TypeOfTransport type;
//	1 - auto
//	2 - train
//	3 - all
	
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public Integer getMaxCarryingCapacity() {
		return maxCarryingCapacity;
	}
	public void setMaxCarryingCapacity(Integer maxCarryingCapacity) {
		this.maxCarryingCapacity = maxCarryingCapacity;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TypeOfTransport getType() {
		return type;
	}
	public void setType(TypeOfTransport type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "AbstractTransport [ id= " + getId() + ", maxCarryingCapacity=" + maxCarryingCapacity + ", maxPrice=" + maxPrice + ", name=" + name + ", type="
				+ type + "]";
	}

	
}
