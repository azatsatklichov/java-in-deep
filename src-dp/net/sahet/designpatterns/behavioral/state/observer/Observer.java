package net.sahet.designpatterns.behavioral.state.observer;

public abstract class Observer {

	protected Topic topic;

	abstract void update();
}
