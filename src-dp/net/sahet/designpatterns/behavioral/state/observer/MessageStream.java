package net.sahet.designpatterns.behavioral.state.observer;

import java.util.ArrayDeque;
import java.util.Deque;

public class MessageStream extends Topic {

	private Deque<String> messageHistory = new ArrayDeque<>();

	@Override
	void setState(String message) {
		messageHistory.add(message);
		this.notifyObservers();
	}

	@Override
	String getState() {
		return messageHistory.getLast();
	}
}
