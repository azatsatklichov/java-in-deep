package net.sahet.java.core.lang.blocks;

/**
 * Once you've declared an enum, it's not expandable. At runtime, there's no way
 * to make additional enum constants. Of course, you can have as many variables
 * as you'd like refer to a given enum constant, so it's important to be able to
 * compare two enum reference variables to see if they're "equal," i.e. do they
 * refer to the same enum constant. You can use either the == operator or the
 * equals() method to determine if two variables are referring to the same enum
 * constant:
 * 
 */

enum MyEnum { // by default implements Serializable

	BIR, IKI

}

// You can use either the == operator or the equals()
class EnumEqual {
	enum Color {
		RED, BLUE
	} // ; is optional

	/**
	 * Equality for Enums
	 * 
	 * Once you've declared an enum, it's not expandable. At runtime, there's no way
	 * to make additional enum constants. Of course, you can have as many variables
	 * as you'd like refer to a given enum constant, so it's important to be able to
	 * compare two enum reference variables to see if they're "equal", i.e. do they
	 * refer to the same enum constant. You can use either the == operator or the
	 * equals() method to determine if two variables are referring to the same enum
	 * constant:
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Color c1 = Color.RED;
		Color c2 = Color.RED;
		/**
		 * {@link see class EnumBaeldung}
		 */
		if (c1 == c2) {
			System.out.println("Two ENUMS, are ==");
			System.out.println("Also guarantes  NULL SAFETY  ");
		}
		if (c1.equals(c2)) {
			System.out.println("Two ENUMS, are in  dot equals");
			System.out.println("Not guarantes  NULL SAFETY, Causes NPE see EnumBaeldung.java  ");
		}
	}
}