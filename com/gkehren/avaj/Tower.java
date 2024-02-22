package com.gkehren.avaj;

public class Tower {

	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		oberservers.add(flyable);
	}

	public void unregister(Flyable flyable) {
		oberservers.remove(flyable);
	}

	protected void conditionsChanged() {
		for (Flyable flyable : observers) {
			flyable.updateConditions();
		}
	}
}
