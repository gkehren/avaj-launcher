package com.gkehren.avaj;

import com.gkehren.avaj.Coordinates;
import com.gkehren.avaj.Simulator.SimulatorException;

public class AircraftFactory {

	public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) throws SimulatorException {
		if (longitude < 0 || latitude < 0 || height < 0) {
			throw new SimulatorException("Error: Negative coordinates are not allowed for aircraft");
		}
		if (height > 100) {
			height = 100;
		}

		Coordinates coordinates = new Coordinates(longitude, latitude, height);
		if (type.toLowerCase().equals("jetplane")) {
			return new JetPlane(name, coordinates);
		} else if (type.toLowerCase().equals("helicopter")) {
			return new Helicopter(name, coordinates);
		} else if (type.toLowerCase().equals("baloon")) {
			return new Baloon(name, coordinates);
		} else {
			throw new SimulatorException("Error: Unknown aircraft type: " + type);
		}
	}
}
