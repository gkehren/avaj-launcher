package com.gkehren.avaj;

public class JetPlane extends Aircraft implements Flyable {

	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude() + 10,
				this.coordinates.getHeight() + 2
			);
			FileWriter.getInstance().writeLine("JetPlane#" + this.name + "(" + this.id + "): The sun is shining and the weather is sweet.");
		}
		else if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude() + 5,
				this.coordinates.getHeight()
			);
			FileWriter.getInstance().writeLine("JetPlane#" + this.name + "(" + this.id + "): It's raining. Better watch out for lightings.");
		}
		else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude() + 1,
				this.coordinates.getHeight()
			);
			FileWriter.getInstance().writeLine("JetPlane#" + this.name + "(" + this.id + "): It's foggy. I can't see anything.");
		}
		else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(
				this.coordinates.getLongitude(),
				this.coordinates.getLatitude(),
				this.coordinates.getHeight() - 7
			);
			FileWriter.getInstance().writeLine("JetPlane#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");
		}

		if (this.coordinates.getHeight() <= 0) {
			FileWriter.getInstance().writeLine("JetPlane#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
			FileWriter.getInstance().writeLine("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		FileWriter.getInstance().writeLine("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
		//FileWriter.getInstance().writeLine("With coordinates: " + this.coordinates.getLongitude() + " " + this.coordinates.getLatitude() + " " + this.coordinates.getHeight() + ".");
	}
}
