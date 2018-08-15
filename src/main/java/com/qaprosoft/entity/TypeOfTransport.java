package com.qaprosoft.entity;

public enum TypeOfTransport {
	
	FOR_TRACK(1), FOR_TRAIN(2), FOR_ALL(3);
	
	private int id;
	
	private TypeOfTransport(int id) {
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
	}
	
	
	
}
