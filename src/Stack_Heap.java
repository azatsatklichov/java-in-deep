package net.sahet.iviews;

/**
 * 
 * For now, we're going to worry about only three types of things: instance
 * variables, local variables, and objects:
 * 
 * - Instance variables and objects live on the heap.
 * 
 * - Local variables live on the stack. (local variables: variables in method,
 * method argument, method parameter) //here localRef reference variable is
 * //created in STACK, but object itself //is created in HEAP
 * 
 * @author Admin
 * 
 */
public class Stack_Heap {

}

class Collar {
}

class Dog {
	Collar c; // instance variable
	String name; // instance variable

	/**
	 * primitive variables in Class definitions are created on STACK
	 */
	int primitive;

	public Dog(String string) {
		name = string;
	}

	@Override
	public String toString() {

		return name;
	}

	public Dog() {

	}

	public static void main(String[] args) {

		Dog d; // local variable: d
		d = new Dog(); // object Dog
		d.go(d);
	}

	void go(Dog dog) { // local variable: dog
		c = new Collar();
		dog.setName("Fido");
	}

	void setName(String dogName) { // local var: dogName
		name = dogName;
		// do more stuff
	}
}
