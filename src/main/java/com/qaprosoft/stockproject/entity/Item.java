package com.qaprosoft.entity;

public class Item extends AbstractEntity{
	
	private String name;
	private Integer weight;
	private Integer price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [ id " + getId() + ", name=" + name + ", weight=" + weight + ", price=" + price + "]";
	}
	
	

}
