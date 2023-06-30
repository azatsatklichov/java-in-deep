package net.sahet.iviews;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C_Generics {

	public static void main(String[] args) {
		/**
		 * The Legacy Way to Do Collections
		 * 
		 * Here's a review of a pre-Java 5 ArrayList intended to hold Strings.
		 * (We say "intended" because that's about all you had—good 
		 * intentions—to make sure that the ArrayList would hold only Strings).
		 */

		List myList = new ArrayList(); // can't declare a type
		myList.add("Fred"); // OK, it will hold Strings
		// myList.add(new Dog()); // and it will hold Dogs too
		myList.add(new Integer(42)); // and Integers...

		// generics - tpe safe
		/*
		 * So, generics takes care of both ends (the putting in and getting out)
		 * by enforcing the type of your collections. Let's update the String
		 * list:
		 */
		List<String> myListg = new ArrayList<String>();
		myListg.add("Fred"); // OK, it will hold Strings
		// myListg.add(new Dog()); // compiler error!!
	}
}

/**
 * Mixing Generic and Non-generic Collections
 * 
 * 
 * Now here's where it starts to get interesting…imagine we have an ArrayList,
 * of type Integer, and we're passing it into a method from a class whose source
 * code we don't have access to. Will this work?
 */
// a Java 5 class using a generic collection
class TestLegacy {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		// type safe collection
		myList.add(4);
		myList.add(6);
		Adder adder = new Adder();
		int total = adder.addAll(myList);
		// pass it to an untyped argument
		System.out.println(total);
	}
}

class Adder {
	int addAll(List list) {
		// method with a non-generic List argument,
		// but assumes (with no guarantee) that it will be Integers
		Iterator it = list.iterator();
		int total = 0;
		while (it.hasNext()) {
			int i = ((Integer) it.next()).intValue();
			total += i;
		}
		return total;
	}
}

class TestBadLegacy {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(4);
		myList.add(6);
		Inserter in = new Inserter();
		in.insert(myList); // pass List<Integer> to legacy code

	}
}

class Inserter {
	// method with a non-generic List argument
	void insert(List list) {
		list.add(new Integer(42)); // adds to the incoming list

	}

	/*
	 * Sure, above (insert) code works. It compiles, and it runs. The insert()
	 * method puts an Integer into the list that was originally typed as
	 * <Integer>, so no problem. But…what if we modify the insert() method like
	 * below:
	 */
	void insert2(List list) {
		list.add(new String("42")); // put a String in the list
									// passed in
	}
}

/**
 * Generic Methods
 * 
 * If you weren't already familiar with generics, you might be feeling very
 * uncomfortable with the implications of the previous
 * no-polymorphic-assignment- for-generic-types thing.
 * 
 * And why shouldn't you be uncomfortable? One of the biggest benefits of
 * polymorphism is that you can declare, say, a method argument of a particular
 * type and at runtime be able to have that argument refer to any subtype—
 * including those you'd never known about at the time you wrote the method with
 * the supertype argument.
 * 
 * For example, imagine a classic (simplified) polymorphism example of a
 * veterinarian (AnimalDoctor) class with a method checkup(). And right now, you
 * have three Animal subtypes—Dog, Cat, and Bird—each implementing the
 * 
 * abstract checkup() method from Animal:
 */

abstract class Animalh {
	public abstract void checkup();
}

class Dogh extends Animalh {
	public void checkup() { // implement Dog-specific code
		System.out.println("Dog checkup");
	}
}

class Cath extends Animalh {
	public void checkup() { // implement Cat-specific code
		System.out.println("Cat checkup");
	}
}

class Birdh extends Animalh {
	public void checkup() { // implement Bird-specific code
		System.out.println("Bird checkup");
	}
}

class AnimalDoctorh {
	// method takes an array of any animal subtype
	public void checkAnimals(Animalh[] animals) {
		for (Animalh a : animals) {
			a.checkup();
		}
	}

	public static void main(String[] args) {
		// test it
		Dogh[] dogs = { new Dogh(), new Dogh() };
		Cath[] cats = { new Cath(), new Cath(), new Cath() };
		Birdh[] birds = { new Birdh() };
		AnimalDoctorh doc = new AnimalDoctorh();
		doc.checkAnimals(dogs); // pass the Dog[]
		doc.checkAnimals(cats); // pass the Cat[]
		doc.checkAnimals(birds); // pass the Bird[]
	}
}

class AnimalDoctorGenerich {
	// change the argument from Animal[] to ArrayList<Animal>
	public void checkAnimals(ArrayList<Animalh> animals) {
		for (Animalh a : animals) {
			a.checkup();
		}
	}

	public static void main(String[] args) {
		// make ArrayLists instead of arrays for Dog, Cat, Bird
		List<Dogh> dogs = new ArrayList<Dogh>();
		dogs.add(new Dogh());
		dogs.add(new Dogh());
		List<Cath> cats = new ArrayList<Cath>();
		cats.add(new Cath());
		cats.add(new Cath());
		List<Birdh> birds = new ArrayList<Birdh>();
		birds.add(new Birdh());
		// this code is the same as the Array version
		AnimalDoctorGenerich doc = new AnimalDoctorGenerich();

		// this worked when we used arrays instead of ArrayLists
		/*
		 * doc.checkAnimals(dogs); // send a List<Dog> doc.checkAnimals(cats);
		 * // send a List<Cat> doc.checkAnimals(birds); // send a List<Bird>
		 */
	}
}

// / generic class
class RentalGeneric<T> { // "T" is for the type
	// parameter
	private List<T> rentalPool; // Use the class type for the
	// List type
	private int maxNum;

	public RentalGeneric(int maxNum, List<T> rentalPool) { // constructor takes
															// a
		// List of the class type
		this.maxNum = maxNum;
		this.rentalPool = rentalPool;
	}

	public T getRental() { // we rent out a T
		// blocks until there's something available
		return rentalPool.get(0);
	}

	public void returnRental(T returnedThing) { // and the renter
												// returns a T
		rentalPool.add(returnedThing);
	}
}
