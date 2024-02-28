package com.gkehren.avaj;

public class Helicopter extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 10,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() + 2
			);
			FileWriter.getInstance().writeLine("Helicopter#" + this.name + "(" + this.id + "): The sun is shining and the weather is sweet.");
		} else if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 5,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight()
			);
			FileWriter.getInstance().writeLine("Helicopter#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.");
		} else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude() + 1,
				this.coordinates.getLatitude(),
				this.coordinates.getHeight()
			);
			FileWriter.getInstance().writeLine("Helicopter#" + this.name + "(" + this.id + "): It's foggy. I can't see anything.");
		} else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 12
			);
			FileWriter.getInstance().writeLine("Helicopter#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");
		}

		if (this.coordinates.getHeight() <= 0) {
			FileWriter.getInstance().writeLine("Helicopter#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
			FileWriter.getInstance().writeLine("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		FileWriter.getInstance().writeLine("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
		//FileWriter.getInstance().writeLine("With coordinates: " + this.coordinates.getLongitude() + " " + this.coordinates.getLatitude() + " " + this.coordinates.getHeight() + ".");
	}
}
