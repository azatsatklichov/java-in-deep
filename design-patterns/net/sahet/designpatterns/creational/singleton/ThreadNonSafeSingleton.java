package net.sahet.designpatterns.creational.singleton;

/**
 * JVM creates the unique instance of this class when the class is loaded
 * 
 * Pros(+) and Cons(-)
 * 
 * + Works fine and provides single instance for Single-Threaded Model
 * 
 * - Non thread safe for multi-threaded app.
 * 
 * - Via reflection still you can create multiple instance of this class
 * 
 * - Eagerly instantiated, slow performance
 */
public class ThreadNonSafeSingleton {

	private static ThreadNonSafeSingleton instance = new ThreadNonSafeSingleton();

	/**
	 * private constructor is not visible besides this class
	 */
	private ThreadNonSafeSingleton() {

	}

	public static ThreadNonSafeSingleton getInstance() {
		return instance;
	}

	@Override
	public String toString() {
		return "Hello from " + this.getClass().getSimpleName() + "#" + hashCode();
	}
}
