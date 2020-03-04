package net.sahet.designpatterns.creational.singleton;

/**
 * JVM creates the unique instance of this class when the class is loaded
 * 
 * Pros(+) and Cons(-)
 * 
 * + Thread safe on multi-threaded app.
 * 
 * + Performance improved via lazy load
 * 
 * + Lazy initialized
 * 
 * + You can not create multiple instance via reflection
 * 
 * - volatile usage causes broken synchronization with less version than JDK 1.5
 * 
 */
public class ThreadSafeSingleton {

	/**
	 * volatile guarantees visibility between threads
	 */
	private static volatile ThreadSafeSingleton instance;

	/**
	 * You can not create multiple instance via reflection and private constructor
	 * is not visible besides this class.
	 */
	private ThreadSafeSingleton() {
		if (instance != null) {
			throw new RuntimeException(
					"This class is designed to provide single instance, so use getInstance() method to get that single instance.");
		}
	}

	/**
	 * 
	 * Thread safe - Double check mechanism guarantees only one instance is used
	 * between threads
	 * 
	 * @return
	 */
	public static ThreadSafeSingleton getInstance() {

		if (instance == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}

	@Override
	public String toString() {
		return "Hello from " + this.getClass().getSimpleName() + "#" + hashCode();
	}
}
