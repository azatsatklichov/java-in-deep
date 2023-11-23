package net.sahet.java.core.lang.building.blocks;

public class Equality4Primitives {

}

class ComparePrimitives {
	public static void main(String[] args) {
		System.out.println("char 'a' == 'a'? " + ('a' == 'a'));
		System.out.println("char 'a' == 'b'? " + ('a' == 'b'));
		System.out.println("5 != 6? " + (5 != 6));
		

        System.out.println("5.0 == 5? " + (5.0 == 5));
        System.out.println("5  == 5l? " + (5 == 5l));
        
		System.out.println("5.0 == 5L? " + (5.0 == 5L)); 
		System.out.println("5.0 == 5l? " + (5.0 == 5l));
		System.out.println("5.0 == 5 " + (5.0 == 5));

		System.out.println("\n3.14 == 3.14f ? " + (3.14 == 3.14f));
		System.out.println("3.14 == 3.14F ? " + (3.14 == 3.14F));
		System.out.println("3.14 == 3.14  ? " + (3.14 == 3.14 ));
		System.out.println("3.14 == 3.14d  ? " + (3.14 == 3.14d ));
		System.out.println("3.14 == 3.14D  ? " + (3.14 == 3.14D ));
		
		float fz = 3.14f;
		System.out.println("\n3.14 == 3.14f ? " + (fz == 3.14f));
		System.out.println("3.14 == 3.14F ? " + (fz == 3.14F));

		System.out.println("true == false? " + (true == false));

		float f = 5.0f;
		// double f = 5.0f; //same
		System.out.println("\nf == 5 " + (f == 5));
		System.out.println("\nf == 5L " + (f == 5L));

		float f2 = 5.0f;
		System.out.println("\nf == f2 " + (f == f2));

		double d2 = 5.;
		System.out.println("\nf == d2 " + (f == d2));
	}
}
