package net.sahet.iviews;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
public class SerizlizetionGRAPH_OK {

}

class Dog2 implements Serializable {

	private static final long serialVersionUID = 6845006778637528860L;
	private Collar2 theCollar;
	private int dogSize;

	public Dog2(Collar2 collar, int size) {
		theCollar = collar;
		dogSize = size;
	}

	public Collar2 getCollar() {
		return theCollar;
	}
}

class Collar2 implements Serializable {

	private static final long serialVersionUID = 664561983024617778L;
	private int collarSize;

	public Collar2(int size) {
		collarSize = size;
	}

	public int getCollarSize() {
		return collarSize;
	}
}

class SerializeDog {
	public static void main(String[] args) {
		Collar2 c = new Collar2(3);
		Dog2 d = new Dog2(c, 5);
		System.out.println("before: collar size is "
				+ d.getCollar().getCollarSize());
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
			d = (Dog2) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("after:  collar size is "
				+ d.getCollar().getCollarSize());

		/**
		 * 
		 * <p>
		 * This produces the output:
		 * 
		 * <pre>
		 *  before: collar size is 3
		 *   
		 *  after:  collar size is 3
		 * 
		 * </pre>
		 * 
		 * 
		 * 
		 * But what would happen if we didn't have access to the Collar class
		 * source code?
		 * 
		 * see: SerizlizetionGRAPH_Problematic, Serialization_Transient
		 * 
		 * In other words, what if making the Collar class serializable was not
		 * an option?
		 * 
		 * Are we stuck with a non-serializable Dog? Obviously we could subclass
		 * the Collar class, mark the subclass as Serializable, and then use the
		 * Collar subclass instead of the Collar class.
		 * 
		 * But that's not always an option either for several potential reasons:
		 * 
		 * <pre>
		 *   1.    The Collar class might be final, preventing subclassing.
		 *        OR
		 *        
		 *   2.     The Collar class might itself refer to other non-serializable objects, and with-
		 * out knowing the internal structure of Collar, you aren't able to make all these 
		 * fixes (assuming you even wanted to TRY to go down that road).
		 * OR
		 * 
		 *   3.    Subclassing is not an option for other reasons related to your design.
		 * </pre>
		 * 
		 * 
		 * So…THEN what do you do if you want to save a Dog? That's where the
		 * transient modifier comes in. If you mark the Dog's Collar instance
		 * variable with transient, then serialization will simply skip the
		 * Collar during serialization:
		 * </p>
		 * 
		 */

	}
}
