package net.sahet.iviews;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * If a superclass is Serializable, then according to normal Java interface
 * rules, all subclasses of that class automatically implement Serializable
 * implicitly.
 * 
 * In other words, a subclass of a class marked Serializable passes the IS-A
 * test for Serializable, and thus can be saved without having to explicitly
 * mark the subclass as Serializable.
 * 
 * You simply cannot tell whether a class is or is not Serializable UNLESS you
 * can see the class inheritance tree to see if any other superclasses implement
 * Serializable.
 * 
 * If the class does not explicitly extend any other class, and does not
 * implement Serializable, then you know for CERTAIN that the class is not
 * Serializable, because class Object does NOT implement Serializable.
 * 
 * 
 * 
 * <p>
 * Desc:
 * </p>
 * 
 * <pre>
 *  Now you have a Serializable Dog class, with a non-Serializable superclass. This 
 * works! But there are potentially serious implications. 
 * 
 * To fully understand those 
 * implications, let's step back and look at the difference between an object that comes 
 * from deserialization vs. an object created using new. 
 * 
 * Remember, when an object 
 * is constructed using new (as opposed to being deserialized), the following things 
 * happen (in this order):
 * 
 *  1.  All instance variables are assigned default values.
 *  
 *  2.  The constructor is invoked, which immediately invokes the superclass  
 *   constructor (or another overloaded constructor, until one of the overloaded
 *   constructors invokes the superclass constructor).
 *   
 *  3.  All superclass constructors complete.
 *  
 *  4.  Instance variables that are initialized as part of their declaration are assigned 
 *   their initial value (as opposed to the default values they're given prior to 
 *   the superclass constructors completing).
 *   
 *  5.  The constructor completes.
 * But these things do NOT happen when an object is deserialized. When an instance of
 * </pre>
 * 
 * 
 */
public class Serizlization_Inheritance_Issues {

}

/*
 * So, that's what happens when the object is deserialized, and the class of the
 * serialized object directly extends Object, or has ONLY serializable classes
 * in its inheritance tree. It gets a little trickier when the serializable
 * class has one or more non-serializable superclasses. Getting back to our
 * non-serializable Animal class with a serializable Dog subclass example:
 */
class AnimalQ {
	public String name;
}

class DogQ extends AnimalQ implements Serializable {
	// the rest of the Dog code
}

/*
 * In fact, every constructor ABOVE the first non-serializable class constructor
 * will also run, no matter what, because once the first super constructor is
 * invoked, it of course invokes its super constructor and so on up the
 * inheritance tree. For the exam, you'll need to be able to recognize which
 * variables will and will not be restored with the appropriate values when an
 * object is deserialized, so be sure to study the following code example and
 * the output:
 */

class SuperNotSerial {
	/**
	 * Because Animal is NOT serializable, any state maintained in the Animal
	 * class, even though the state variable is inherited by the Dog, isn't
	 * going to be restored with the Dog when it's deserialized!
	 * 
	 * The reason is, the (unserialized) Animal part of the Dog is going to be
	 * reinitialized just as it would be if you were making a new Dog (as
	 * opposed to deserializing one). That means all the things that happen to
	 * an object
	 * 
	 * during construction, will happen—but only to the Animal parts of a Dog.
	 * 
	 * In other words, the instance variables from the Dog's class will be
	 * serialized and deserialized correctly,
	 * 
	 * but the inherited variables from the non-serializable Animal superclass
	 * will come back with their default/initially assigned values rather than
	 * the values they had at the time of serialization.
	 * 
	 * If you are a serializable class, but your superclass is NOT serializable,
	 * then any instance variables
	 * 
	 * you INHERIT from that superclass will be reset to the values they were
	 * given during the original construction of the object. This is because the
	 * non- serializable class constructor WILL run!
	 */
	public static void main(String[] args) {
		DogW d = new DogW(35, "Fido");
		System.out.println("before: " + d.name + " " + d.weight);
		try {
			FileOutputStream fs = new FileOutputStream("testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("testSer.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			d = (DogW) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * Because Animal is NOT serializable, any state maintained in the
		 * Animal class, even though the state variable is inherited by the Dog,
		 * isn't going to be restored with the Dog when it's deserialized!
		 * 
		 * The reason is, the (unserialized) Animal part of the Dog is going to
		 * be reinitialized just as it would be if you were making a new Dog (as
		 * opposed to deserializing one). That means all the things that happen
		 * to an object
		 * 
		 * 
		 * // MUST have default constructor during deserialization
		 */
		System.out.println("after:  " + d.name + " " + d.weight);
	}
}

class DogW extends AnimalW implements Serializable {
	String name;

	DogW(int w, String n) {

		weight = w; // inherited
		name = n; // not inherited

	}
}

class AnimalW { // not serializable !
	int weight = 42;

	// MUST have default constructor during deserialization
}

/*
 * which produces the output: before: Fido 35 after: Fido 42
 */

