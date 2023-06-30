package net.sahet.iviews;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Object Graphs
 * 
 * <pre>
 * 
 * What does it really mean to save an object? If the instance variables are all primitive 
 * types, it's pretty straightforward.
 * 
 * But what if the instance variables are themselves 
 * references to objects? What gets saved? 
 * 
 * Clearly in Java it wouldn't make any sense to 
 * save the actual value of a reference variable, because the value of a Java reference has 
 * meaning only within the context of a single instance of a JVM. 
 * 
 * In other words, if you 
 * tried to restore the object in another instance of the JVM, even running on the same 
 * computer on which the object was originally serialized, the reference would be useless.
 * 
 * 
 * 
 * 
 * 
 * Now what happens if you save the Dog? If the goal is to save and then restore
 * a Dog, and the restored Dog is an exact duplicate of the Dog that was saved,
 * then the Dog needs a Collar that is an exact duplicate of the Dog's Collar at
 * the time the Dog was saved. That means both the Dog and the Collar should be
 * saved. And what if the Collar itself had references to other objects—like
 * perhaps a Color object? This gets quite complicated very quickly. 
 * 
 * If it were
 * up to the programmer to know the internal structure of each object the Dog
 * referred to, so that the programmer could be sure to save all the state of
 * all those objects…whew. That would be a nightmare with even the simplest of
 * objects. Fortunately, the Java serialization mechanism takes care of all of
 * this. 
 * 
 * When you serialize an object, Java serialization takes care of saving
 * that object's entire "object graph." That means a deep copy of everything the
 * saved object needs to be restored. For example, if you serialize a Dog
 * object, the Collar will be serialized automatically. 
 * 
 * And if the Collar class
 * contained a reference to another object, THAT object would also be
 * serialized, and so on. 
 * 
 * And the only object you have to worry about saving and
 * restoring is the Dog. The other objects required to fully reconstruct that
 * Dog are saved (and restored) automatically through serialization. 
 * 
 * Remember,
 * you do have to make a conscious choice to create objects that are
 * serializable, by implementing the Serializable interface. If we want to save
 * Dog objects, for example, we'll have to modify the Dog class as follows:
 * </pre>
 * 
 * 
 * 
 */
public class SerizlizetionGRAPH_Problematic {

}

class Dog {
	private Collar theCollar;
	private int dogSize;

	public Dog(Collar collar, int size) {
		theCollar = collar;
		dogSize = size;
	}

	public Collar getCollar() {
		return theCollar;
	}
}

class Collar {
	private int collarSize;

	public Collar(int size) {
		collarSize = size;
	}

	public int getCollarSize() {
		return collarSize;
	}
}

class SerializeDog__NotSerializableException {
	public static void main(String[] args) {
		Collar c = new Collar(3);
		Dog d = new Dog(c, 8);
		try {
			FileOutputStream fs = new FileOutputStream("testSer.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(d);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
