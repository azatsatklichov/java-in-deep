package net.sahet.iviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Collections come in four basic flavors:
 * 
 * <pre>
 * 
 * ■  Lists  Lists of things (classes that implement List).
 * 
 * ■  Sets  Unique things (classes that implement Set).
 * 
 * ■  Maps Things with a unique ID (classes that implement Map).
 * 
 * ■  Queues Things arranged by the order in which they are to be processed.
 * 
 * 
 * An implementation class can be unsorted and unordered, ordered but unsorted, or 
 * both ordered and sorted. But an implementation can never be sorted but unordered, 
 * because sorting is a specific type of ordering, as you'll see in a moment.
 * 
 *  For example, a HashSet is an unordered, unsorted set, while a LinkedHashSet is an ordered (but 
 * not sorted) set that maintains the order in which objects were inserted.
 * Maybe we should be explicit about the difference between sorted and ordered, but 
 * first we have to discuss the idea of iteration. 
 * 
 * When you think of iteration, you may 
 * think of iterating over an array using, say, a for loop to access each element in the 
 * array in order ([0], [1], [2], and so on). Iterating through a collection usually means 
 * walking through the elements one after another starting from the first element.
 * </pre>
 * 
 */
public class Collection_API {

	public static void main(String[] args) {
		// Autoboxing with Collections
		System.out.println("---- Autoboxing with Collections");
		/*
		 * In general, collections can hold Objects but not primitives. Prior to
		 * Java 5, a very common use for the wrapper classes was to provide a
		 * way to get a primitive into a collection. Prior to Java 5, you had to
		 * wrap a primitive by hand before you could put it into a collection.
		 * With Java 5, primitives still have to be wrapped, but autoboxing
		 * takes care of it for you.
		 */
		List myInts = new ArrayList(); // pre Java 5 declaration
		myInts.add(new Integer(42)); // had to wrap an int
		// As of Java 5 we can say
		myInts.add(42); // autoboxing handles it!
		/*
		 * In this last example, we are still adding an Integer object to myInts
		 * (not an int primitive); it's just that autoboxing handles the
		 * wrapping for us.
		 */

		// Sorting Collections and Arrays
		System.out.println("\n----  Sorting Collections and Arrays");
		/*
		 * Sorting and searching topics have been added to the exam for Java 5.
		 * Both collections and arrays can be sorted and searched using methods
		 * in the API.
		 */
		/*
		 * Let's start with something simple like sorting an ArrayList of
		 * Strings alphabetically. What could be easier? Okay, we'll wait while
		 * you go find ArrayList's sort() method…got it? Of course, ArrayList
		 * doesn't give you any way to sort its contents, but the
		 * java.util.Collections class does
		 */

		ArrayList<String> stuff = new ArrayList<String>(); // #1
		stuff.add("Denver");
		stuff.add("Boulder");
		stuff.add("Vail");
		stuff.add("Aspen");
		stuff.add("Telluride");
		System.out.println("unsorted " + stuff);
		Collections.sort(stuff); // #2 ///here, String implements Comparable,
									// otherwise you must implement Comparable
		System.out.println("sorted   " + stuff);

		System.out.println("   sorting after implementing Comparable");
		ArrayList<DVDInfo> dvdList = new ArrayList<DVDInfo>();
		populateList(); // adds the file data to the ArrayList
		System.out.println(dvdList);
		// Now that we've got a populated ArrayList, let's sort it:
		Collections.sort(dvdList);

	}

	public static void populateList() {
		// read the file, create DVDInfo instances, and
		// populate the ArrayList dvdlist with these instances
	}
}

/**
 * In our home-automation application, we want to create an instance of DVDInfo
 * for each line of data we read in from the dvdInfo.txt file. For each
 * instance, we will parse the line of data (remember String.split()?) and
 * populate DVDInfo's three instance variables. Finally, we want to put all of
 * the DVDInfo instances into an ArrayList. Imagine that the populateList()
 * method (below) does all of this. Here is a small piece of code from our
 * application:
 * 
 */

class DVDInfo implements Comparable<DVDInfo> { // #1

	String title;
	String genre;
	String leadActor;

	DVDInfo(String t, String g, String a) {
		title = t;
		genre = g;
		leadActor = a;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	public String toString() {
		return title + " " + genre + " " + leadActor + "\n";
	}

	/**
	 * It’s important to remember that when you override equals() you MUST take
	 * an argument of type Object, but that when you override compareTo() you
	 * should take an argument of the type you’re sorting.
	 */
	public int compareTo(DVDInfo d) {
		// existing code
		// public int compareTo(Object o) { // takes an Object rather
		// than a specific type
		// DVDInfo d = (DVDInfo) o;
		return title.compareTo(d.getTitle());
	}

}

class SearchObjArray {
	/**
	 * Here's what happened:
	 * 
	 * <pre>
	 * Line 1 Sort the sa array, alphabetically (the natural order).
	 * 
	 * Line 2 Search for the location of element "one", which is 1.
	 * 
	 * Line 3  Make a Comparator instance. On the next line we re-sort the array using 
	 * the Comparator.
	 * 
	 * Line 4  Attempt to search the array. We didn't pass the binarySearch() 
	 * method the Comparator we used to sort the array, so we got an incorrect 
	 * (undefined) answer.
	 * 
	 * Line 5  Search again, passing the Comparator to binarySearch(). This time 
	 * we get the correct answer, 2
	 * 
	 * Line 6  We define the Comparator; it's okay for this to be an inner class.
	 * 
	 * Line 7  By switching the use of the arguments in the invocation of 
	 * compareTo(), we get an inverted sort.
	 * 
	 * </pre>
	 * 
	 */
	public static void main(String[] args) {
		String[] sa = { "one", "two", "three", "four" };
		Arrays.sort(sa); // #1
		for (String s : sa)
			System.out.print(s + " ");
		System.out.println("\none = " + Arrays.binarySearch(sa, "one")); // #2
		System.out.println("-- now reverse sort");
		ReSortComparator rs = new ReSortComparator(); // #3
		Arrays.sort(sa, rs);
		for (String s : sa)
			System.out.print(s + " ");
		System.out.println("\none = " + Arrays.binarySearch(sa, "one")); // #4
		System.out.println("one = " + Arrays.binarySearch(sa, "one", rs)); // #5
	}

	static class ReSortComparator implements Comparator<String> { // #6
		public int compare(String a, String b) {
			return b.compareTo(a); // #7
		}
	}
}

class Conversion_Array_List {
	/**
	 * Converting Arrays to Lists to Arrays
	 * 
	 * There are a couple of methods that allow you to convert arrays to Lists,
	 * and Lists to arrays. The List and Set classes have toArray() methods, and
	 * the Arrays class has a method called asList().
	 * 
	 * 
	 * The Arrays.asList () method copies an array into a List. The API says,
	 * "Returns a fixed-size list backed by the specified array. (Changes to the
	 * returned list 'write through' to the array.)"
	 * 
	 * When you use the asList() method, the array and the List become joined at
	 * the hip. When you update one of them, the other gets updated
	 * automatically. Let's take a look:
	 */
	public static void main(String[] args) {
		String[] sa = { "one", "two", "three", "four" };
		List sList = Arrays.asList(sa); // make a List
		// this convesrion is BACKED
		System.out.println("size  " + sList.size());
		System.out.println("idx2  " + sList.get(2));
		sList.set(3, "six"); // change List
		sa[1] = "five"; // change array
		for (String s : sa)
			System.out.print(s + " ");
		System.out.println("\nsl[1] " + sList.get(1));

		/*
		 * Now let's take a look at the toArray() method. There's nothing too
		 * fancy going on with the toArray() method; it comes in two flavors:
		 * one that returns a new Object array, and one that uses the array you
		 * send it as the destination array:
		 */

		List<Integer> iL = new ArrayList<Integer>();
		for (int x = 0; x < 3; x++)
			iL.add(x);
		// NOT BACKED, completely NEW array generated
		Object[] oa = iL.toArray(); // create an Object array
		Integer[] ia2 = new Integer[3];
		ia2 = iL.toArray(ia2); // create an Integer array
	}
}

class Dogn {
	public String name;

	Dogn(String n) {
		name = n;
	}
}

/**
 * Using Lists
 * 
 * 
 * Remember that Lists are usually used to keep things in some kind of order.
 * You can use a LinkedList to create a first-in, first-out queue. You can use
 * an ArrayList to keep track of what locations were visited, and in what order.
 * 
 * Notice that in both of these examples it's perfectly reasonable to assume
 * that duplicates might occur. In addition, Lists allow you to manually
 * override the ordering of elements by adding or removing elements via the
 * element's index.
 * 
 * Before Java 5, and the enhanced for loop, the most common way to examine a
 * List "element by element" was by the use of an Iterator.
 * 
 */
class ListTest {
	public static void main(String[] args) {
		List<Dogn> d = new ArrayList<Dogn>();
		Dogn dog = new Dogn("aiko");
		d.add(dog);
		d.add(new Dogn("clover"));
		d.add(new Dogn("magnolia"));
		Iterator<Dogn> i3 = d.iterator(); // make an iterator
		while (i3.hasNext()) {
			Dogn d2 = i3.next(); // cast not required
			System.out.println(d2.name);
		}
		System.out.println("size " + d.size());
		System.out.println("get1 " + d.get(1).name);
		System.out.println("aiko " + d.indexOf(dog));
		d.remove(2);
		Object[] oa = d.toArray();
		for (Object o : oa) {
			Dogn d2 = (Dogn) o;
			System.out.println("oa " + d2.name);
		}
	}
}

/**
 * Using Sets Remember that Sets are used when you don't want any duplicates in
 * your collection.
 * 
 * If you attempt to add an element to a set that already exists in the set, the
 * duplicate element will not be added, and the add() method will return false.
 * 
 * 
 * Remember, HashSets tend to be very fast because, as we discussed earlier,
 * they use hashcodes.
 * 
 * You can also create a TreeSet, which is a Set whose elements are sorted. You
 * must use caution when using a TreeSet (we're about to explain why):
 */

class SetTest {
	public static void main(String[] args) {
		boolean[] ba = new boolean[5];
		// insert code here
		// Set s = new HashSet(); // insert this code

		// If you insert this line of code you'll get something like this:
		Set s = new TreeSet(); // insert this code //elements MUST be
								// COMAPARABLE-MUTUALLY

		ba[0] = s.add("a");
		ba[1] = s.add(new Integer(42));
		ba[2] = s.add("b");
		ba[3] = s.add("a");
		ba[4] = s.add(new Object());
		for (int x = 0; x < ba.length; x++)
			System.out.print(ba[x] + " ");
		System.out.println("\n");
		for (Object o : s)
			System.out.print(o + " ");
	}
}

class Dogm {
	public Dogm(String n) {
		name = n;
	}

	public String name;

	public boolean equals(Object o) {
		if ((o instanceof Dogm) && (((Dogm) o).name == name)) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return name.length();
	}
}

class Catm {
}

enum Petsm {
	DOG, CAT, HORSE
}

/**
 * Using Maps
 * 
 * 
 * Remember that when you use a class that implements Map, any classes that you
 * use as a part of the keys for that map must override the hashCode() and
 * equals() methods. (Well, you only have to override them if you're interested
 * in retrieving stuff from your Map.
 * 
 * Seriously, it's legal to use a class that doesn't override equals() and
 * hashCode() as a key in a Map; your code will compile and run, you just won't
 * find your stuff.) Here's some crude code demonstrating the use of a HashMap:
 */
class MapTest {
	public static void main(String[] args) {
		Map<Object, Object> m = new HashMap<Object, Object>();
		m.put("k1", new Dogm("aiko")); // add some key/value pairs
		m.put("k2", Petsm.DOG);
		m.put(Petsm.CAT, "CAT key");
		Dogm d1 = new Dogm("clover"); // let's keep this reference
		m.put(d1, "Dog key");
		m.put(new Catm(), "Cat key"); // Catm does not override hashCode
		System.out.println(m.get("k1")); // #1
		String k2 = "k2";
		System.out.println(m.get(k2)); // #2
		Petsm p = Petsm.CAT;
		System.out.println(m.get(p)); // #3
		System.out.println(m.get(d1)); // #4
		System.out.println(m.get(new Catm())); // #5 //can not find object 
		System.out.println(m.size()); // #6

		/**
		 * The Dogm that was previously found now cannot be found. Because the
		 * Dogm.name variable is used to create the hashcode, changing the name
		 * changed the value of the hashcode.
		 * 
		 * As a final quiz for hashcodes, determine the output for the following
		 * lines of code if they're added to the end of MapTest.main():
		 */
		d1.name = "magnolia";
		System.out.println(m.get(d1)); // #1
		d1.name = "clover";
		System.out.println(m.get(new Dogm("clover"))); // #2
		d1.name = "arthur"; //try disabling this
		System.out.println(m.get(new Dogm("clover"))); // #3
	}
}
