package net.sahet.iviews;

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
 *  
 * 
 */
public class GC_IslandsOfIsolation {

}

class Island {
	Island i;

	public static void main(String[] args) {
		Island i2 = new Island();
		Island i3 = new Island();
		Island i4 = new Island();
		i2.i = i3; // i2 refers to i3
		i3.i = i4; // i3 refers to i4
		i4.i = i2; // i4 refers to i2
		i2 = null;
		i3 = null;
		i4 = null;
		// do complicated, memory intensive stuff
	}
}
