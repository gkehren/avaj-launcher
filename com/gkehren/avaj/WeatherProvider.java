package com.gkehren.avaj;

import java.util.Random;

public class WeatherProvider {

	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		int index = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() + randomNum) % 4;
		return weather[index];
	}
}
