package com.gkehren.avaj;

import com.gkehren.avaj.WeatherTower;
import com.gkehren.avaj.Coordinates;

public class Baloon extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		// TODO: Implement this method
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
