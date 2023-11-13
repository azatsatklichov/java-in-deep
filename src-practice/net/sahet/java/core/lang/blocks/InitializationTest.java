package net.sahet.java.core.lang.blocks;

public class InitializationTest {
	/*
	 * What is the result?
	 * 
	 * A. pre b1 b2 r3 r2 hawk
	 * 
	 * B. pre b2 b1 r2 r3 hawk
	 * 
	 * C. pre b2 b1 r2 r3 hawk r1 r4
	 * 
	 * D. r1 r4 pre b1 b2 r3 r2 hawk
	 * 
	 * E. r1 r4 pre b2 b1 r2 r3 hawk
	 * 
	 * F. pre r1 r4 b1 b2 r3 r2 hawk
	 * 
	 * G. pre r1 r4 b2 b1 r2 r3 hawk
	 * 
	 * H. The order of output cannot be predicted
	 * 
	 * I. Compilation fails
	 */

}

class Birdd {
	{
		System.out.print("b1 ");
	}

	public Birdd() {
		System.out.print("b2 ");
	}
}

class Raptor extends Birdd {
	static {
		System.out.print("r1 ");
	}

	public Raptor() {
		System.out.print("r2 ");
	}

	{
		System.out.print("r3 ");
	}
	static {
		System.out.print("r4 ");
	}
}

/**
 * D is correct.
 * 
 * Static init blocks are executed at class loading time, instance init blocks
 * run right after the call to super() in a constructor. When multiple init
 * blocks of a single type occur in a class, they run in order, from the top
 * down.
 * 
 * 
 */

class Test {
	{
		System.out.print("t1 ");
	}

	public Test() {
		System.out.print("t2 ");
	}

	public Test(int i) {
		System.out.print("t3 ");
	}
}

class TestInit extends Test {
	static {
		System.out.print("i1 ");
	}

	public TestInit() {
		System.out.print("i2 ");
	}

	{
		System.out.print("i3 ");
	}

	static {
		System.out.print("i4 ");
	}

	public static void main(String[] args) {
		System.out.print("abc ");
		new TestInit();
		System.out.println("xyz ");
		new TestInit();
	}
}

class Mixer {
	Mixer() {
	}

	Mixer(Mixer m) {
		m1 = m;
	}

	Mixer m1;

	public static void main(String[] args) {
		Mixer m2 = new Mixer();
		Mixer m3 = new Mixer(m2);
		m3.go();
		Mixer m4 = m3.m1;
		m4.go();
		Mixer m5 = m2.m1;
		m5.go(); // hi hi Exception in thread "main" java.lang.NullPointerException
	}

	void go() {
		System.out.print("hi ");
	}
}