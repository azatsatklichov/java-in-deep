package net.sahet.java.core.lang.building.blocks;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * In this article, we will be looking at a WeakHashMap from the java.util
 * package.
 * 
 * <pre>
 * In order to understand the data structure, we'll use it here to roll out a
 * simple cache implementation. However, keep in mind that this is meant to
 * understand how the map works, and creating your own cache implementation is
 * almost always a bad idea.
 * 
 * Simply put, the WeakHashMap is a hashtable-based implementation of the Map interface, with keys that 
 * are of a WeakReference type.

An entry in a WeakHashMap will automatically be removed when its key is no longer in ordinary use, 
meaning that there is no single Reference that point to that key. When the garbage collection (GC) 
process discards a key, its entry is effectively removed from the map, so this class behaves somewhat differently 
from other Map implementations.
 *
 * </pre>
 */
public class StrongSoftWeakRefs_WeakHashMapInJava {

	// Strong References
	/**
	 * //Strong References Integer prime = 1;
	 */
	Integer prime = 1;

	{
		/**
		 * Soft References Simply put, an object that has a SoftReference pointing to it
		 * won't be garbage collected until the JVM absolutely needs memory.
		 */
		SoftReference<Integer> soft = new SoftReference<Integer>(prime);
		prime = null;

		/**
		 * Weak References
		 * 
		 * The objects that are referenced only by weak references are garbage collected
		 * eagerly; the GC won't wait until it needs memory in that case.
		 */
		Integer prime = 1;
		WeakReference<Integer> soft2 = new WeakReference<Integer>(prime);
		prime = null;
		System.out.println("References of a WeakReference type are used as keys in WeakHashMap.");
	}

	 
}
