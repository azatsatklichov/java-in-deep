package net.sahet.iviews;

public class Overloading_BoxThenWiden {

}



class Eggs {
	int doX(Long x, Long y) {
		return 1;
	}

	int doX(long... x) {
		return 2;
	}

	int doX(Integer x, Integer y) {
		return 3;
	}

	int doX(Number n, Number m) {
		return 4;
	}

	public static void main(String[] args) {
		new Eggs().go();
	}

	void go() {
		short s = 7;
		System.out.print(doX(s, s) + " "); // short-->Short subclass of Number
											// //Box then Widen
		System.out.println(doX(7, 7)); // int-->Integer
		
		/*
		 * oTwo rules apply to the first invocation of doX(). You can�t
		 * widen and then box in one step, and var-args are always chosen last.
		 * Therefore you can�t widen shorts to either ints or longs, and then box them
		 * to Integers or Longs. But you can box shorts to Shorts and
		 */
	}
}