package net.sahet.iviews;

import java.util.Date;

/**
 * 
 * 
 * 
 * <p>
 * 1-way: Nulling a Reference
 * </p>
 * 
 * <pre>
 * Nulling a Reference As we discussed earlier, an object becomes eligible for
 * garbage collection when there are no more reachable references to it.
 * Obviously, if there are no reachable references, it doesn't matter what
 * happens to the object. For our purposes it is just floating in space, unused,
 * inaccessible, and no longer needed. The first way to remove a reference to an
 * object is to set the reference variable that refers to the object to null.
 * Examine the following code:
 * </pre>
 * 
 * 
 * @author
 * 
 */
public class GC_EligiblityOfObjects_3Ways {
}

class GarbageTruck {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("hello");
		System.out.println(sb);
		// The StringBuffer object is not eligible for collection
		sb = null;
		// Now the StringBuffer object is eligible for collection
	}
}

/**
 * 
 * <p>
 * 2-way: Reassigning a Reference Variable
 * </p>
 * 
 * <pre>
 *   Reassigning a Reference Variable We can also decouple a reference variable
 * from an object by setting the reference variable to refer to another object.
 * Examine the following code:
 * </pre>
 * 
 */
class GarbageTruck2 {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("hello");
		StringBuffer s2 = new StringBuffer("goodbye");
		System.out.println(s1);
		// At this point the StringBuffer "hello" is not eligible
		s1 = s2; // Redirects s1 to refer to the "goodbye" object
		// Now the StringBuffer "hello" is eligible for collection
	}
}

/**
 * 
 * <p>
 * 3-way: in a method.
 * </p>
 * 
 * <pre>
 * All objects which are used inside the method are automatically eligible for
 *  garbage collection
 *  
 *  Objects that are created in a method also need to be considered. When a
 *  method is invoked, any local variables created exist only for the duration of
 *  the method. Once the method has returned, the objects created in the method
 *  are eligible for garbage collection. There is an obvious exception, however.
 *  If an object is returned from the method, its reference might be assigned to
 *  a reference variable in the method that called it; hence, it will not be
 *  eligible for collection. Examine the following code:
 * </pre>
 */

class GarbageFactory {
	/*
	 * In the preceding example, we created a method called getDate() that
	 * returns a Date object. This method creates two objects: a Date and a
	 * StringBuffer containing the date information. Since the method returns
	 * the Date object, it will not be eligible for collection even after the
	 * method has completed. The StringBuffer object, though, will be eligible,
	 * even though we didn't explicitly set the now variable to null.
	 */
	public static void main(String[] args) {
		Date d = getDate();
		doComplicatedStuff();
		System.out.println("d = " + d);
	}

	private static void doComplicatedStuff() {
		// Auto-generated method stub

	}

	public static Date getDate() {
		Date d2 = new Date();
		StringBuffer now = new StringBuffer(d2.toString());
		System.out.println(now);
		return d2;
	}
}

/**
 * 
 * <p>
 * Isolating a Reference (or islands of isolation)
 * </p>
 * 
 * <pre>
 *   There is another way in which objects can become eligible for garbage
 * collection, even if they still have valid references! 
 * We call this scenario  "islands of isolation." 
 * 
 * A simple example is a class that has an instance
 * variable that is a reference variable to another instance of the same class.
 * Now imagine that two such instances exist and that they refer to each other.
 * If all other references to these two objects are removed, then even though
 * each object still has a valid reference, there will be no way for any live
 * thread to access either object. When the garbage collector runs, it can
 * usually discover any such islands of objects and remove them. 
 * 
 * As you can
 * imagine, such islands can become quite large, theoretically containing
 * hundreds of objects. Examine the following code:
 * </pre>
 * 
 * @see GC_IslandsOfIsolation {@link GC_IslandsOfIsolation}
 * 
 */
class IslandsOfIsolation {
    
    public static void main(String[] args) {
        String aString  = null;
        if (aString == null || !aString.equals("ola"))  {
                   System.out.println("ss"); 
        }

        if (aString == null | !aString.equals("ola"))  {
                  System.out.println("ss"); 
        }

    }

}
