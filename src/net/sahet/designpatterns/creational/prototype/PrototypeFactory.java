package net.sahet.designpatterns.creational.prototype;

/**
 * Prototype
 * 
 * is used once we use new instance of class each time.
 * 
 * e.g. As we know from Spring, prototype beans provide new instance each time.
 * 
 * There is two option to implement this facade pattern, via shallow cloning or
 * deep cloning your prototype. Both approach has different behavior on runtime.
 * 
 * If the class has only primitive and immutable fields, it is a good candidate
 * for shallow copy.
 * 
 * If it contains mutable fields the use deep-copy. And if deep copy is needed,
 * then handle it using in memory serialization.
 * 
 */
public abstract class PrototypeFactory implements Cloneable {
	public PrototypeFactory clone() throws CloneNotSupportedException {
		PrototypeFactory copy = (PrototypeFactory) super.clone();

		return copy;
	}

	abstract void prototypeFactory(int x);

	abstract void printValue();
}

/**
 * Concrete Prototypes to clone
 */
class PrototypeImpl extends PrototypeFactory {
	int x;

	public PrototypeImpl(int x) {
		this.x = x;
	}

	@Override
	void prototypeFactory(int x) {
		this.x = x;
	}

	public void printValue() {
		System.out.println("Value :" + x);
	}
}
