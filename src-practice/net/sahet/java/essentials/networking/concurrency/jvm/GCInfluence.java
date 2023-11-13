package net.sahet.java.essentials.networking.concurrency.jvm; 
import java.util.Date;

/**
 * /**
 * 
 * 
 * 
 * <pre>
 *  The garbage collection routines that Java provides are members of the Runtime
 * class. The Runtime class is a special class that has a single object (a
 * Singleton) for each main program. The Runtime object provides a mechanism for
 * communicating directly with the virtual machine. To get the Runtime instance,
 * you can use the method Runtime.getRuntime(), which returns the Singleton.
 * Once you have the Singleton you can invoke the garbage collector using the
 * gc() method. Alternatively, you can call the same method on the System class,
 * which has static methods that can do the work of obtaining the Singleton for
 * you. The simplest way to ask for garbage collection (remember—just a request)
 * is System.gc();
 * 
 * 
 * Theoretically, after calling System.gc(), you will have as much free memory
 * as possible. We say theoretically because this routine does not always work
 * that way. First, your JVM may not have implemented this routine; the language
 * specification allows this routine to do nothing at all. Second, another
 * thread (again, see the Chapter 9) might grab lots of memory right after you
 * run the garbage collector. This is not to say that System.gc() is a useless
 * method—it's much better than nothing. You just can't rely on System.gc() to
 * free up enough memory so that you don't have to worry about running out of
 * memory. The Certification Exam is interested in guaranteed behavior, not
 * probable behavior.
 * </pre>
 * 
 * 
 * 
 */

class CheckGC {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		System.out.println("  in the beginning ");
		checkMemory(rt);

		Date[] d = new Date[1000000];
		for (int i = 0; i < 1000000; i++) {
			d[i] = new Date();
		}
		System.out.println("\n  after creating some objects");
		checkMemory(rt);

		System.out.println("\n  after nullifying   objects");
		for (int i = 0; i < 1000000; i++) {
			d[i] = null;
		}
		checkMemory(rt);

		System.gc(); // requsting to JVM for GC
		System.out.println(
				"\n  after nulliforcing CG - actually just requsting to JVM, no guarantee if JVM performs it or NOT");
		checkMemory(rt);

	}

	private static void checkMemory(Runtime rt) {
		System.out.println("Available memory = " + rt.maxMemory() / 1000000 + "MB bytes");
		long totalMemory = rt.totalMemory();
		System.out.println("Total JVM TOTAL  memory: " + totalMemory / 1000000 + "MB bytes");

		long freeMemory = rt.freeMemory();
		System.out.println("free Memory = " + freeMemory / 1000000 + "MB bytes");

		System.out.println("used Heap Memory = " + (totalMemory - freeMemory) / 1000000 + "MB bytes");

	}
}

/**
 * <p>
 * Description
 * </p>
 * 
 * <pre>
 
 
 * 
 *  The boolean type has exactly two values: true and false.
 * 
 * Where for integral types:
 * 
 *     The integral types are byte, short, int, and long, whose values are 8-bit, 16-bit, 
 *     32-bit and 64-bit signed two's-complement integers, respectively, and char, 
 *     whose values are 16-bit unsigned integers representing Unicode characters.
 * 
 * So you have required bit depth for integral types but it is solely up to you if your boolean will be 
 * represented in the memory as a single bit, byte or multibyte variable when you implement your own JVM.
 * 
 * </pre>
 */
class LotsOfBooleans {
	boolean a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
	boolean b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
	boolean c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
	boolean d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
	boolean e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
}

class LotsOfInts {
	int a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, aa, ab, ac, ad, ae, af;
	int b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bb, bc, bd, be, bf;
	int c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, ca, cb, cc, cd, ce, cf;
	int d0, d1, d2, d3, d4, d5, d6, d7, d8, d9, da, db, dc, dd, de, df;
	int e0, e1, e2, e3, e4, e5, e6, e7, e8, e9, ea, eb, ec, ed, ee, ef;
}

class TestB {
	private static final int SIZE = 1000000;

	public static void main(String[] args) throws Exception {
		LotsOfBooleans[] first = new LotsOfBooleans[SIZE];
		LotsOfInts[] second = new LotsOfInts[SIZE];

		System.gc();
		long startMem = getMemory();

		for (int i = 0; i < SIZE; i++) {
			first[i] = new LotsOfBooleans();
		}

		System.gc();
		long endMem = getMemory();

		System.out.println("Size for LotsOfBooleans: " + (endMem - startMem));
		System.out.println("Average size: " + ((endMem - startMem) / ((double) SIZE)));

		System.gc();
		startMem = getMemory();
		for (int i = 0; i < SIZE; i++) {
			second[i] = new LotsOfInts();
		}
		System.gc();
		endMem = getMemory();

		System.out.println("Size for LotsOfInts: " + (endMem - startMem));
		System.out.println("Average size: " + ((endMem - startMem) / ((double) SIZE)));

		// Make sure nothing gets collected
		long total = 0;
		for (int i = 0; i < SIZE; i++) {
			total += (first[i].a0 ? 1 : 0) + second[i].a0;
		}
		System.out.println(total);
	}

	private static long getMemory() {
		Runtime runtime = Runtime.getRuntime();
		return runtime.totalMemory() - runtime.freeMemory();
	}
}
