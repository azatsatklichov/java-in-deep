package net.sahet.designpatterns.behavioral.state.observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverDemo {
	public static void main(String[] args) {
		System.out.println(
				"\n	Observer design pattern example - we do not use Java build-in Observable, and Observer, but we implement it ourselves ");

		Topic topic = new MessageStream(); // or call it subject

		BrowserClient client1 = new BrowserClient(topic);
		DesktopClient client2 = new DesktopClient(topic);

		client1.addMessage("chrome message");
		client2.addMessage("win-desktop message");
		client1.addMessage("last chrome message");

		System.out.println();
		System.out.println("\n	Observer Java build-in classes ");
		/**
		 * java.util.Observer (interface) java.util.Observable (class, even name looks
		 * like interface)
		 * 
		 * java.util.EventListener javax.jms.Topic
		 * 
		 */
		News observedNews = new News();
		NewsReaderObserver1 reader1 = new NewsReaderObserver1();
		NewsReaderObserver2 reader2 = new NewsReaderObserver2();
		observedNews.addObserver(reader1);
		observedNews.addObserver(reader2);

		observedNews.news();

	}
}

class NewsReaderObserver1 implements Observer {

	public void update(Observable obj, Object arg) {
		System.out.println("Observer1 recevived: " + arg);
	}
}

class NewsReaderObserver2 implements Observer {
	public void update(Observable obj, Object arg) {
		System.out.println("Observer2 recevived: " + arg);
	}
}

class News extends Observable {
	void news() {
		String[] news = { "News1", "News2", "News3", "News4" };
		for (String s : news) {
			setChanged();
			notifyObservers(s);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println("Error: " + e);
			}
			System.out.println();
		}
	}
}