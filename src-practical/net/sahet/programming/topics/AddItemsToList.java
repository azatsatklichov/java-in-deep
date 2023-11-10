package net.sahet.programming.topics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;

/**
 * https://www.baeldung.com/java-add-items-array-list
 */
public class AddItemsToList {

	/**
	 * Remove Nulls from a List Using Google Guava
	 */
	@Test
	public void addAll() {
		List<Integer> list = Lists.newArrayList(null, 1, null);

		List<Integer> anotherList = Arrays.asList(5, 12, 9, 3, 15, 88);
		list.addAll(anotherList);

		assertEquals(list.size(), 9);
	}

	@Test
	public void collectionsAddAll() {
		List<Integer> list = Lists.newArrayList(null, 1, null);

		Collections.addAll(list, 1, 2, 3, 4, 5);
		assertEquals(list.size(), 8);

		list = new ArrayList<>();
		Collections.addAll(list, 1, 2, 3, 4, 5);
		assertEquals(list.size(), 5);

		/*
		 * And another one to exemplify the operation with two arrays:
		 */
		list = Lists.newArrayList(null, 1, null); // Arrays.asList(5, 12, 9, 3, 15, 88); //List.of(3, 4);
													// java.lang.UnsupportedOperationException
		Integer[] otherList = new Integer[] { 1, 2, 3, 4, 5 };
		Collections.addAll(list, otherList);
	}

	@Test
	public void addJava8Way() {
		List<Integer> list = Lists.newArrayList(null, null, 1, 4, 6, 7);

		List<Integer> target = new LinkedList<>();
		list.stream().forEachOrdered(target::add);

		System.out.println(target);
		assertEquals(target.size(), 6);

		/**
		 * The main advantages of this way are the opportunity to use skip and filters.
		 * In the next example we're going to skip the first element:
		 * 
		 * It's possible to filter the elements by our necessities. For instance, the
		 * Integer value:
		 */

		target = new LinkedList<>();
		// skipp NULLs, then choose only odd numbers
		list.stream().skip(2).filter(i -> i % 2 != 0).forEachOrdered(target::add);
		System.out.println(target);
		assertEquals(target.size(), 2);

		target = new LinkedList<>();
		// NULL SAFE
		Optional.ofNullable(list).ifPresent(target::addAll);
		System.out.println("-" + target);
		assertEquals(target.size(), 6);

		target = new LinkedList<>();
		List<Integer> nullList = List.of();
		Optional.ofNullable(nullList).ifPresent(target::addAll);
		System.out.println("-" + target);
		assertEquals(target.size(), 0);

		//forEach
		target = new LinkedList<>();
		list.stream().forEach(target::add);
		System.out.println(target);
		assertEquals(target.size(), 6);
	}

	@Test
	public void addJava8Way2() {
		CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[] { 1, 3, 5, 8 });
		System.out.println(numbers);
		Assertions.assertThrows(ConcurrentModificationException.class, () -> {
			List<Integer> asList = Arrays.asList(44, 67, -7);
			List<Integer> result = new LinkedList<>(asList);
			result.iterator().forEachRemaining(result::add);
			assertEquals(result.size(), 7);
		});

		List<Integer> asList = Arrays.asList(44, 67, -7);
		List<Integer> result = new LinkedList<>(asList);
		numbers.iterator().forEachRemaining(result::add);
		assertEquals(result.size(), 7);
		System.out.println(result);

	}

}
