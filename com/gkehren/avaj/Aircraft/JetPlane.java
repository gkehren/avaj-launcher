package com.gkehren.avaj;

import com.gkehren.avaj.WeatherTower;
import com.gkehren.avaj.Coordinates;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates) {
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
		System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
