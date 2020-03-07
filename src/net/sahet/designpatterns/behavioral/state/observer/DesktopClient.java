package net.sahet.designpatterns.behavioral.state.observer;

public class DesktopClient extends Observer {

	public DesktopClient(Topic topic) {
		this.topic = topic;
		topic.subscribe(this);
	}

	public void addMessage(String message) {
		topic.setState(message + " - from desktop");
	}

	@Override
	void update() {
		System.out.println("Desktop stream: " + topic.getState());
	}
}
