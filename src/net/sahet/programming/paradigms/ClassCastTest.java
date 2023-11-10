package net.sahet.programming.paradigms;

class DogY {
}

class Beagle extends DogY {
}

class Kennel {
	public static void main(String[] arfs) {
		Beagle b1 = new Beagle();
		DogY dog1 = new DogY();
		DogY dog2 = b1;
		// insert code here
		// Which, inserted at line 9, will compile? (Choose all that apply.)
		Beagle b2 = (Beagle) dog1; // ClassCastException at runtime
		Beagle b3 = (Beagle) dog2;
		// Beagle b4 = dog2; //compile error

		// shu yokardaky sowalz, b2 u-n GEMALTO da soradylar
		// A and B are correct. However, at runtime, A will throw a ClassCastException
		// because
		// dog1 refers to a Dog object, which can�t necessarily do Beagle stuff.
	}
}

////////////////

class RedwoodT extends TreeT {
	public static void main(String[] args) {
		new RedwoodT().go();
	}

	void go() {
		go2(new TreeT(), new RedwoodT());
		go2((RedwoodT) new TreeT(), new RedwoodT()); // 1-arg
														// java.lang.ClassCastException,
														// ata bala
														// assign--edilip
														// bilinmeyar
	}

	void go2(TreeT t1, RedwoodT r1) {
		RedwoodT r2 = (RedwoodT) t1; // java.lang.ClassCastException, ata bala
										// assign--edilip bilinmeyar
		TreeT t2 = (TreeT) r1;
	}
}

class TreeT {
}

// //////// test 2
class Tenor extends Singer {
	public static String sing() {
		return "fa";
	}

	public static void main(String[] args) {
		Tenor t = new Tenor();
		Singer s = new Tenor();
		System.out.println(t.sing() + " " + s.sing());
	}
}

class Singer {
	public static String sing() {
		return "la";
	}
}

//

class Animal5 {
	void makeNoise() {
		System.out.println("generic noise");
	}
}

class Dog5 extends Animal5 {
	void makeNoise() {
		System.out.println("bark");
	}

	void playDead() {
		System.out.println("roll over");
	}
}

class CastTest5 {
	public static void main(String[] args) {
		Animal5[] a = { new Animal5(), new Dog5(), new Animal5() };
		for (Animal5 animal : a) {
			animal.makeNoise();
			if (animal instanceof Dog5) {
				// animal.playDead(); // try to do a Dog behavior ?

				// another way
				// ((Dog5) animal).playDead();
				Dog5 d = (Dog5) animal; // casting the ref. var.
				d.playDead();
			}
		}
	}
}

/**
 * The new and improved code block contains a cast, which in this case is
 * sometimes called a downcast, because we're casting down the inheritance tree
 * to a more specific class. Now, the compiler is happy. Before we try to invoke
 * playDead, we cast the animal variable to type Dog. What we're saying to the
 * compiler is, "We know it's really referring to a Dog object, so it's okay to
 * make a new Dog reference variable to refer to that object." In this case
 * we're safe because before we ever try the cast, we do an instanceof test to
 * make sure. It's important to know that the compiler is forced to trust us
 * when we do a downcast, even when we screw up:
 */
class Animal7 {
}

class Dog7 extends Animal7 {
}

class DogTest {
	public static void main(String[] args) {
		Animal7 animal = new Animal7();
		Dog7 d = (Dog7) animal; // compiles but fails later:
								// java.lang.ClassCastException

		/*
		 * However, if the compiler knows with certainty that the cast could not
		 * possibly work, compilation will fail. The following replacement code block
		 * will NOT compile:
		 */
		Animal7 animal2 = new Animal7();
		Dog7 d2 = (Dog7) animal;
		// String s = (String) animal; // animal can't EVER be a String:
		// inconvertible types
	}
}

// ////////////// now upcasting
/*
 * Unlike downcasting, upcasting (casting up the inheritance tree to a more
 * general type) works implicitly (i.e., you don't have to type in the cast)
 * because when you upcast you're implicitly restricting the number of methods
 * you can invoke, as opposed to downcasting, which implies that later on, you
 * might want to invoke a more specific method. For instance:
 */
class Animal9 {
}

class Dog9 extends Animal9 {
}

class DogTest9 {
	public static void main(String[] args) {
		/*
		 * Both of the below upcasts will compile and run without exception, because a
		 * Dog IS-A Animal, which means that anything an Animal can do, a Dog can do.
		 */
		Dog9 d = new Dog9();
		Animal9 a1 = d; // upcast ok with no explicit cast
		Animal9 a2 = (Animal9) d; // upcast ok with an explicit cast
	}
}