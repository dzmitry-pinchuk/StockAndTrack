package com.qaprosoft.stockproject.entity.transport;

import com.qaprosoft.stockproject.entity.AbstractEntity;
import com.qaprosoft.stockproject.entity.TypeOfTransport;

public abstract class AbstractTransport extends AbstractEntity {

	private Integer maxCarryingCapacity;
	private String name;
	private TypeOfTransport type;
//	1 - auto
//	2 - train

	public Integer getMaxCarryingCapacity() {
		return maxCarryingCapacity;
	}

	public void setMaxCarryingCapacity(Integer maxCarryingCapacity) {
		this.maxCarryingCapacity = maxCarryingCapacity;
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
		return "AbstractTransport [ id= " + getId() + ", maxCarryingCapacity=" + maxCarryingCapacity + ", name=" + name
				+ "]";
	}

}
