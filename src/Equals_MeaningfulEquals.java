package net.sahet.iviews;

public class Equals_MeaningfulEquals {

	public static void main(String[] args) {

		/**
		 * Desc:
		 * 
		 * <pre>
		 * Boxing, ==, and equals()
		 * We just used == to do a little exploration of wrappers. Let's take a more thorough 
		 * look at how wrappers work with ==, !=, and equals(). We'll talk a lot more about 
		 * the equals() method in later chapters. For now all we have to know is that the 
		 * intention of the equals() method is to determine whether two instances of a given 
		 * class are "meaningfully equivalent." This definition is intentionally subjective; it's 
		 * up to the creator of the class to determine what "equivalent" means for objects of the 
		 * class in question. The API developers decided that for all the wrapper classes, two 
		 * objects are equal if they are of the same type and have the same value. It shouldn't 
		 * be surprising that
		 * </pre>
		 * 
		 */
		Integer i1 = 1000;
		Integer i2 = 1000;
		if (i1 != i2)
			System.out.println("different objects");
		if (i1.equals(i2))
			System.out.println("meaningfully equal");

		/**
		 * It's just two wrapper objects that happen to have the same value.
		 * Because they have the same int value, the equals() method considers
		 * them to be "meaningfully equivalent", and therefore returns true. How
		 * about this one:
		 */
		Integer i3 = 10;
		Integer i4 = 10;
		if (i3 == i4)
			System.out
					.println("\nname object WOW equals, what a SURPRISE, Short and Integer from -128 to 127 for optimization");
		
		/**
		 * {@link Test_Indra}
		 */
		if (i3.equals(i4))
			System.out.println("meaningfully equal");
		/**
		 * Desc:
		 * 
		 * <pre>
		 * Yikes! The equals() method seems to be working, but what happened with == 
		 * and != ? Why is != telling us that i1 and i2 are different objects, when == is saying 
		 * that i3 and i4 are the same object? In order to save memory, two instances of the 
		 * following wrapper objects will always be ==  when their primitive values are the same:
		 * n  Boolean
		 * n  Byte
		 * n  Character from \u0000 to \u007f     (7f is 127 in decimal)
		 * n  Short and Integer from -128 to 127
		 * </pre>
		 * 
		 */

	}

}
