package net.sahet.iviews;

public class InstanceTest {
	/**
	 * In addition, it is legal to test whether the null reference is an
	 * instance of a class. This will always result in false, of course. For
	 * example: <br />
	 * 
	 * An object is said to be of a particular interface type (meaning it will
	 * pass the instanceof test) if any of the object's superclasses implement
	 * the interface.
	 */
	public static void main(String[] args) {
		/**
		 * Remember that arrays are objects, even if the array is an array of
		 * primitives. Watch for questions that look something like this:
		 */
		int[] nums = new int[3];
		if (nums instanceof Object) {
			System.out.println(" int[] nums  instanceof Object ==> "
					+ Boolean.TRUE);

		} // result is true
		/**
		 * An array is always an instance of Object. Any array.
		 */

		String a = null;
		boolean b = null instanceof String;
		boolean c = a instanceof String;

		System.out.println(" null instanceof String => " + b);

		System.out.println(" a instanceof String => " + c);

		boolean o = null instanceof Object;
		System.out.println(" null instanceof Object => " + o);

		// arrays //

		/**
		 * Remember that arrays are objects, even if the array is an array of
		 * primitives. Watch for questions that look something like this:
		 */
	}
}

/*
 * instanceof Compiler Error You can't use the instanceof operator to test
 * across two different class hierarchies. For instance, the following will NOT
 * compile:
 */
class Cat {
}

class Dog {

}

/**
 * instanceof Compiler Error
 * 
 * You can't use the instanceof operator to test across two different class
 * hierarchies. For instance, the following will NOT compile:
 */
class InstanceOfCompilerError {
	public static void main(String[] args) {
		Dog d = new Dog();
		// boolean x = d instanceof Cat;
		// System.out.println(x);
	}
	// Compilation fails�there's no way d could ever refer to a Cat
	// or a subtype of Cat.

}
