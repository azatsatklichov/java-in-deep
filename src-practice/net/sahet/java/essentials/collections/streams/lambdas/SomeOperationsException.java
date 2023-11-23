package net.sahet.java.essentials.collections.streams.lambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/**
 * In this quick tutorial, we'll discuss a common Exception that can occur when
 * working with some the API of most List implementations – the
 * UnsupportedOperationException.
 * 
 * https://www.baeldung.com/java-list-unsupported-operation-exception
 * https://www.baeldung.com/java-copy-list-to-another
 * 
 * 
 *
 */
public class SomeOperationsException {

	/**
	 * public static List asList(T... a) It returns:
	 * 
	 * <pre>
		a fixed-size List as of size of a given array
		
		an element of the same type as the one in the original array and it must be an Object
		
		elements in the same order as in original array
		
		a list that is serializable and implements RandomAccess
	 * </pre>
	 * 
	 */
	@Test
	public void whenArrays_asList_assertThrows() throws Exception {
		List<String> flowers = Arrays.asList("Ageratum", "Allium", "Poppy", "Catmint");
		System.out.println(flowers);

		// We can also pass an actual array:
		String[] flowers2 = { "Ageratum", "Allium", "Poppy", "Catmint" };
		List<String> flowerList = Arrays.asList(flowers2);
		System.out.println(flowerList);

		// Since the returned List is a fixed-size List, we can’t add/remove elements.
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			flowerList.add("Celosia");
		});

	}

	@Test
	public void whenArrayList_asList_editable() throws Exception {
		List<String> flowers = Arrays.asList("Ageratum", "Allium", "Poppy", "Catmint");
		System.out.println(flowers);

		System.out.println("2.  It's an ArrayList, from java.util.Arrays.");
		// String[] flowers2 = { "Ageratum", "Allium", "Poppy", "Catmint" };
		List<String> flowerList = new ArrayList<>(
				Arrays.asList(new String[] { "Ageratum", "Allium", "Poppy", "Catmint" }));

		assertEquals(flowerList.size(), 4);
		flowerList.add("Celosia");
		System.out.println(flowerList);

		assertEquals(flowerList.size(), 5);
	}

	@Test
	public void when_modifyDuringCopying_assertThrows() throws Exception {

		/**
		 * This could mean that we're modifying the list while we're trying to copy it,
		 * most likely in another thread.
		 * 
		 * Considering our last approach, it isn't thread-safe. So that if we want to
		 * resolve our problem with the first option, we may want to use
		 * CopyOnWhiteArrayList, in which all mutative operations are implemented by
		 * making a fresh copy of the underlying array.
		 */
		// ConcurrentAccessException, ConcurrentModificationException
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			List<String> flowers = Arrays.asList("Ageratum", "Allium", "Poppy", "Catmint");
			Iterator<String> iterator = flowers.iterator();
			while (iterator.hasNext()) {
				flowers.add("10");
			}
		});
	}

	@Test
	public void when_RemovingWhileIterating_assertThrows() throws Exception {
		// ConcurrentAccessException, ConcurrentModificationException
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[] { 1, 3, 5, 8 });

			Iterator<Integer> iterator = numbers.iterator();
			while (iterator.hasNext()) {
				iterator.remove();
			}
		});
	}

}
