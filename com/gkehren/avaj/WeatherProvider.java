package com.gkehren.avaj;

public class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {
	}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int index = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight()) % 4;
		return weather[index];
	}
}
