package net.sahet.iviews;

/**
 * The key point here is that reference widening depends on inheritance, in
 * other words the IS-A test.
 * 
 * Because of this, it's not legal to widen from one wrapper class to another,
 * because the wrapper classes are peers to one another. For instance, it's NOT
 * valid to say that Short IS-A Integer
 * 
 * @author Admin
 * 
 */
class Animal3x {
	static void eat() {
	}
}

class Dog3x extends Animal3x {
	public static void main(String[] args) {
		Dog3x d = new Dog3x();
		d.go(d); // is this legal ?
		/*
		 * No problem! The go() method needs an Animal3x, and Dog3x IS-A Animal.
		 * 
		 * * So, in this case, the compiler widens the Dog3 reference to an
		 * Animal, and the invocation succeeds.
		 * 
		 * The key point here is that reference widening depends on inheritance,
		 * in other words the IS-A test.
		 */

	}

	void go(Animal3x a) {
	}
}

/*
 * It�s tempting to think that you might be able to widen an Integer wrapper to
 * a Long wrapper, but the following will NOT compile:
 */
class Dog4 {
	public static void main(String[] args) {
		Dog4 d = new Dog4();
		/**
		 * it's not legal to widen from one wrapper class to another, because
		 * the wrapper classes are peers to one another. For instance, it's NOT
		 * valid to say that Short IS-A Integer
		 */
//		d.test(new Integer(5)); // can't widen an Integer

		// to a Long
	}

	void test(Long x) {
	}
}/*
 * Remember, none of the wrapper classes will widen from one to another! Bytes
 * won�t widen to Shorts, Shorts won�t widen to Longs, etc.
 */
