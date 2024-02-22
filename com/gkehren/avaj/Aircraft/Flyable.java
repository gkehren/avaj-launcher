package com.gkehren.avaj.Aircraft;

import com.gkehren.avaj.WeatherTower;

public interface Flyable {

	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
}
