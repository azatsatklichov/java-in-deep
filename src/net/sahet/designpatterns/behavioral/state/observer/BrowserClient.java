package net.sahet.designpatterns.behavioral.state.observer;

public class BrowserClient extends Observer {

	public BrowserClient(Topic topic) {
		this.topic = topic;
		topic.subscribe(this);
	}

	public void addMessage(String message) {
		topic.setState(message + " - sent from browser");
	}

	@Override
	void update() {
		System.out.println("Browser stream: " + topic.getState());
	}
}
