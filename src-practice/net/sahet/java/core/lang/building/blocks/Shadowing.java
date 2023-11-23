package net.sahet.java.core.lang.building.blocks;

/**
 * You can shadow an instance variable by declaring a local variable of the same
 * name, either directly or as part of an argument:
 * 
 * The Shadowy World of _Variables Just when you think you’ve got it all
 * figured out, you see a piece of code with variables not behaving the way you
 * think they should. You might have stumbled into code with a shadowed
 * variable. You can shadow a variable in several ways. We’ll look at the one
 * most likely to trip you up: hiding an instance variable by shadowing it with
 * a local variable. Shadowing involves redeclaring a variable that’s already
 * been declared somewhere else. The effect of shadowing is to hide the
 * previously declared variable in such a way that it may look as though
 * you’re using the hidden variable, but you’re actually using the shadowing
 * variable. You might find reasons to shadow a variable intentionally, but
 * typically it happens by accident and causes hard-to- find bugs. On the exam,
 * you can expect to see questions where shadowing plays a role.
 * 
 */
public class Shadowing {

	/**
	 * The preceding code appears to change the size instance variable in the
	 * changeIt() method, but because changeIt() has a parameter named size, the
	 * local size variable is modified while the instance variable size is
	 * untouched. Running class Foocap prints
	 */
	static int size = 7;

	static void changeIt(int size) {
		size = size + 200;
		System.out.println("size in changeIt is " + size);
	}

	public static void main(String[] args) {
		Shadowing f = new Shadowing();
		System.out.println("size = " + size);
		changeIt(size);
		System.out.println("size after changeIt is " + size);
	}

}

/*
 * Things become more interesting when the shadowed variable is an object
 * reference, rather than a primitive:
 */
class Barcap {
	int barNum = 28;
}

/**
 * Things become more interesting when the shadowed variable is an object
 * reference, rather than a primitive:
 * 
 */
class Foocap {
	Barcap myBarcap = new Barcap();

	void changeIt(Barcap myBarcap) {
		myBarcap.barNum = 99;
		System.out.println("myBarcap.barNum in changeIt is " + myBarcap.barNum);
		myBarcap = new Barcap();
		myBarcap.barNum = 420;
		System.out.println("myBarcap.barNum in changeIt is now " + myBarcap.barNum);
	}

	/**
	 * You can see that the shadowing variable (the local parameter myBar in
	 * changeIt()) can still affect the myBar instance variable, because the myBar
	 * parameter receives a reference to the same Bar object. But when the local
	 * myBar is reassigned a new Bar object, which we then modify by changing its
	 * barNum value, ReturnTypeOverload�s original myBar instance variable is
	 * untouched.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Foocap f = new Foocap();
		System.out.println("f.myBarcap.barNum is " + f.myBarcap.barNum);
		f.changeIt(f.myBarcap);
		System.out.println("f.myBarcap.barNum after changeIt is " + f.myBarcap.barNum);
	}
}


//1-example
class Knowing {
	static final long tooth = 343L;

	static long doIt(long tooth) {
		System.out.print(++tooth + " ");
		return ++tooth;
	}

	public static void main(String[] args) {
		System.out.print(tooth + " ");
		final long tooth = 340L;
		new Knowing().doIt(tooth);
		System.out.println(tooth);

		// mine
		System.out.print(tooth + " ");
	}
}

// 2-example
class Ouch {
	static int ouch = 7;

	public static void main(String[] args) {
		new Ouch().go(ouch);
		System.out.print(" " + ouch);
	}

	void go(int ouch) {
		ouch++;

		// compile error: duplicate local variable
		// for (int ouch = 3; ouch < 6; ouch++) ;

		System.out.print(" " + ouch);
	}
}
