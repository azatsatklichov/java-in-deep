package net.sahet.iviews;

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
public class GC_MemoryCheck {
}

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
		System.out
				.println("\n  after nulliforcing CG - actually just requsting to JVM, no guarantee if JVM performs it or NOT");
		checkMemory(rt);

	}

	private static void checkMemory(Runtime rt) {
		System.out.println("Available memory = " + rt.maxMemory() / 1000000
				+ "MB bytes");
		long totalMemory = rt.totalMemory();
		System.out.println("Total JVM TOTAL  memory: " + totalMemory / 1000000
				+ "MB bytes");

		long freeMemory = rt.freeMemory();
		System.out
				.println("free Memory = " + freeMemory / 1000000 + "MB bytes");

		System.out.println("used Heap Memory = " + (totalMemory - freeMemory)
				/ 1000000 + "MB bytes");

	}
}