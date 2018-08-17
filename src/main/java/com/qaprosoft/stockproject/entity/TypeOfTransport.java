package com.qaprosoft.stockproject.entity;

public enum TypeOfTransport {
	
	FOR_TRACK(1), FOR_TRAIN(2);
	
	private int id;
	
	TypeOfTransport() {
	}
	
	TypeOfTransport(int id) {
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
