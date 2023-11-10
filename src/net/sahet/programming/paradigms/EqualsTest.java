package net.sahet.programming.paradigms;

public class EqualsTest {

	public static void main(String[] args) {
		String s1 = "mary";//in pool
		String s2 = "mary"; //in pool
		if (s1 == s2)
			System.out.println(".TRUE");
		else
			System.out.println(".FALSE");

		if (s1.equals(s2))
			System.out.println("..TRUE");
		else
			System.out.println("..FALSE");

		String s3 = new String("mary");//in heap
		String s4 = new String("mary");//in heap

		if (s3 == s4)
			System.out.println("...TRUE");
		else
			System.out.println("...FALSE");

		if (s3.equals(s4))
			System.out.println("....TRUE");
		else
			System.out.println("....FALSE");

	}
}
