package com.qaprosoft.stockproject.entity.transport;

public class Track extends AbstractTransport {

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Track [color=" + color + super.toString() + "]";
	}

}
