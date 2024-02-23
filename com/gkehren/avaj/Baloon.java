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
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 2,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() + 4
			);
			System.out.println("Baloon#" + this.name + "(" + this.id + "): The sun is shining and the weather is sweet.");
		}
		else if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 5
			);
			System.out.println("Baloon#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.");
		}
		else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 3
			);
			System.out.println("Baloon#" + this.name + "(" + this.id + "): It's foggy. I can't see anything.");
		}
		else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 15
			);
			System.out.println("Baloon#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");
		}

		if (this.coordinates.getHeight() <= 0) {
			System.out.println("Baloon#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
			System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
	}

	public String toString() {
		return "Baloon#" + this.name + "(" + this.id + ")";
	}
}
