package com.qaprosoft.stockproject.entity.transport;

public class Train extends AbstractTransport {

	private int numberOfWagons;

	public int getNumberOfWagons() {
		return numberOfWagons;
	}

	public void setNumberOfWagons(int numberOfWagons) {
		this.numberOfWagons = numberOfWagons;
	}

	@Override
	public String toString() {
		return "\n Train [numberOfWagons=" + numberOfWagons + super.toString() + "]";
	}

}
