package net.sahet.designpatterns.creational.singleton;

/**
 * Single-Threaded Singleton
 * 
 * JVM creates the unique instance of this class when the class is loaded
 * 
 * <pre>
* * Pros(+) and Cons(-)
 * 
 * + Works fine and provides single instance for Single-Threaded Model
 * 
 * - Difficult to unit test
 * 
 * - Non thread safe for multi-threaded app.
 * 
 * - Difficult to unit test
 * 
 * - Via reflection still you can create multiple instance of this class.
 * E.g. via invoking the private constructor reflectively  with help of 
 * AccessibleObject.setAccessible method
 * 
 * - Eagerly instantiated, slow performance
 * 
 * +- [J. Bloch] To make a singleton class that is implemented using either of the previous
		approaches serializable (Chapter 11), it is not sufficient merely to add implements
		Serializable to its declaration. To maintain the singleton guarantee, you
		have to declare all instance fields transient and provide a readResolve method
		(Item 77). Otherwise, each time a serialized instance is deserialized, a new
		instance will be created, leading, in the case of our example, to spurious Elvis
		sightings. To prevent this, add this readResolve method
 * 
 * <code>
 *  readResolve method to preserve singleton property
	private Object readResolve() {
	// Return the one true ThreadNonSafeSingleton and let the garbage collector
	// take care of the ThreadNonSafeSingleton impersonator.
	return INSTANCE;
	}
 * </code>
 * </pre>
 */
public class ThreadNonSafeSingleton {

	private static final ThreadNonSafeSingleton instance = new ThreadNonSafeSingleton();

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
