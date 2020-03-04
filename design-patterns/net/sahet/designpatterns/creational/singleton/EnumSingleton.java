package net.sahet.designpatterns.creational.singleton;

/**
 * Pros(+) and Cons(-)
 * 
 * + JVM ensures only one instantiation of enum so it is by default Thread Safe
 * 
 * + Easy to implement
 * 
 * + No explicit synchronization needed reason is Enums are thread safe
 * 
 * + There are no problems with respect to reflection (you can not create
 * multiple instance) and serialization
 * 
 * - Enum is somewhat inflexible as superclass is always enum
 * 
 * - Enum contains some additional public methods which may make an issue or
 * situation more confused or complicated.
 * 
 *
 */
public enum EnumSingleton {
	INSTANCE;

	public void hi() {
		System.out.println("");
	}

	@Override
	public String toString() {
		return "Hello from " + this.getClass().getSimpleName() + "#" + hashCode();
	}
}
