package net.sahet.designpatterns.behavioral.state.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Topic { // or Subject

	private List<Observer> observers = new ArrayList<>();

	abstract void setState(String state);

	abstract String getState();

	// attach
	public void subscribe(Observer observer) {
		observers.add(observer);
	}

	// detach
	public void unsubscribe(Observer observer) {
		observers.remove(observer);
	}

	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}
}
