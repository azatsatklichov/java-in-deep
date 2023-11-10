package net.sahet.programming.topics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://www.baeldung.com/java-copy-list-to-another
 *
 */
public class CopyList {

	/**
	 * Due to the fact that we're copying reference here and not cloning the
	 * objects, every amends made in one element will affect both lists.
	 * 
	 */
	@Test
	public void whenClassicConstructWay() throws Exception {
		String elm = "Ageratum";
		List<String> flowers = Arrays.asList(elm, "Allium", "Poppy", "Catmint");
		assertEquals(flowers.size(), 4);

		// A simple way to copy a List is by using the constructor that takes a
		// collection as its argument:
		List<String> copy = new ArrayList<>(flowers);

		copy.add("allo");
		assertEquals(copy.size(), 5);

		elm = "sdsds";
		System.out.println(flowers);
		System.out.println(copy);

	}

	@Test
	public void whenAddallWay() throws Exception {
		CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[] { 1, 3, 5, 8 });
		List<Integer> copy = new ArrayList<>();
		copy.addAll(numbers);

		assertEquals(numbers.size(), 4);

		copy.add(34);
		assertEquals(copy.size(), 5);

		System.out.println(numbers);
		System.out.println(copy);
	}

	/**
	 * Collections.copy The Collections class consists exclusively of static methods
	 * that operate on or return collections.
	 */
	@Test
	public void whenCollectionsCopyWay() throws Exception {

		List<Integer> source = Arrays.asList(1, 2, 3);
		List<Integer> dest = Arrays.asList(4, 5, 6);
		Collections.copy(dest, source);

		assertEquals(source.size(), 3);
		System.out.println(source);
		System.out.println(dest);

		System.out.println("Here all elements in the dest list were overwritten because both lists have the same size");
		assertEquals(dest.size(), 3);

		dest = Arrays.asList(4, 5, 6, 44, 55, 66, 88);
		System.out.println("Here we have enough SIZE, so only first successive elements will be overwritten");

		Collections.copy(dest, source);

		assertEquals(7, dest.size());
		System.out.println(source);
		System.out.println(dest);

		/**
		 * java.lang.IndexOutOfBoundsException: Source does not fit in dest.
		 * 
		 * Collections.copy(dest2, source);
		 * 
		 * The destination list must be at least as long as the source list
		 */
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			List<Integer> dest2 = new ArrayList<Integer>(3); // est = new ArrayList<Integer>(4); same
			System.out.println("Here we have enough SIZE, so only first successive elements will be overwritten");
			Collections.copy(dest2, source);
		});

		/**
		 * The destination list must be at least as long as the source list
		 */
		dest = Arrays.asList(4, 5, 12, -5);
		Collections.copy(dest, source);
		assertEquals(4, dest.size());
		System.out.println(source);
		System.out.println(dest);

	}

	@Test
	public void whenJava8CopyWay() throws Exception {

		List<Integer> list = Arrays.asList(1, 2, 3);

		List<Integer> copy = list.stream().collect(Collectors.toList());

		assertEquals(list.size(), 3);
		System.out.println(list);
		System.out.println(copy);

		/**
		 * The main advantages of this way are the opportunity to use skip and filters.
		 * In the next example we're going to skip the first element:
		 */
		copy = list.stream().skip(1).collect(Collectors.toList());

		copy = list.stream().filter(s -> s > 10).collect(Collectors.toList());

		// It's probable we want to work in a null-safe way:
		copy = list.stream().filter(Objects::nonNull).filter(s -> s > 10).collect(Collectors.toList());
	}

	@Test
	public void whenJava10CopyWay() throws Exception {

		List<Integer> list = Arrays.asList(1, 2, null, 3);
		System.out.println(
				"The only conditions are that the given Collection mustn't be null, and it mustn't contain any null elements.");

		List<Integer> nullSafeList = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
		List<Integer> copy = List.copyOf(nullSafeList);

		assertEquals(copy.size(), 3);
		System.out.println(list);
		System.out.println(copy);
	}
}
