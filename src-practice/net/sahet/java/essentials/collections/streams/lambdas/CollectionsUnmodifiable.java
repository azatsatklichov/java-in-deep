package net.sahet.java.essentials.collections.streams.lambdas;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * <pre>
 * here are a couple of changes related to unmodifiable collections in Java 10.
 * </pre>
 */
public class CollectionsUnmodifiable {

	/**
	 * Desc: 3.1. copyOf()
	 *
	 * <pre>
	 *
	 * java.util.List, java.util.Map and java.util.Set each got a new static method copyOf(Collection).
	 *
	 * It returns the unmodifiable copy of the given Collection:
	 *
	 * Any attempt to modify such a collection would result in java.lang.UnsupportedOperationExceptionruntime exception.
	 *
	 * </pre>
	 */
	@Test
	public void whenModifyCopyOf_thenThrowsException() throws UnsupportedOperationException {
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			System.out.println();
			Map<String, Long> agesMap = Map.of("Batyr", 67L, "Myrat", 78L, "Dowran", 88L, "Enar", 90L, "Bahar", 50L,
					"Nary", 95L);
			System.out.println(agesMap);
			Map<String, Long> agesMap2 = Map.copyOf(agesMap);
			System.out.println(agesMap2);
			System.out.println();
			// System.out.println("try to modify unmodifiable map");
			// agesMap2.put("Zaman", 79L);

			Set<String> set = Set.of("Q", "V", "E", "R", "T", "Y");
			System.out.println(set);
			Set<String> set2 = Set.copyOf(set);
			System.out.println(set2);
			System.out.println();
			// System.out.println("try to modify unmodifiable set");
			// set2.add("Z");

			List<String> list = List.of("A", "B", "A", "B", "C");
			System.out.println(list);
			list.add("gg");
			List<String> copyList = List.copyOf(list);
			System.out.println(copyList);
			System.out.println("try to modify unmodifiable list");
			copyList.add("Z");
		});
	}

	/**
	 * return toUnmodifiable*()
	 *
	 * <pre>
	 *
	 * java.util.stream.Collectors get additional methods to collect a Stream into unmodifiable List, Map or Set:
	 *
	 * Any attempt to modify such a collection would result in java.lang.UnsupportedOperationExceptionruntime exception.
	 * </pre>
	 */
	@Test
	public void whenModifyToUnmodifiableList_thenThrowsException() throws UnsupportedOperationException {
		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
			List<Integer> ints = List.of(1, 12, 6, -9, 14, -434);
			List<Integer> evenList = ints.stream().filter(i -> i > 0).collect(Collectors.toUnmodifiableList());
			System.out.println(evenList);
			evenList.add(63);// UnsupportedOperationException
		});
	}

}
