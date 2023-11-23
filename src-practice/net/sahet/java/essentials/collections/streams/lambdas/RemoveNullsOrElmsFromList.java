package net.sahet.java.essentials.collections.streams.lambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * https://www.baeldung.com/java-remove-value-from-list
 * 
 * https://www.baeldung.com/java-remove-nulls-from-list
 *
 */
public class RemoveNullsOrElmsFromList {
 
	/**
	 * Remove Nulls from a List Using Google Guava
	 */
	@Test
	public void givenListContainsNulls_whenRemovingNullsWithGuavaV1_thenCorrect() {
		List<Integer> list = Lists.newArrayList(null, 1, null);
		Iterables.removeIf(list, Predicates.isNull());

		assertEquals(list.size(), 1);
	}

	/**
	 * Alternatively, if we don't want to modify the source list, Guava will allow
	 * us to create a new, filter list:
	 */
	@Test
	public void givenListContainsNulls_whenRemovingNullsWithGuavaV2_thenCorrect() {
		List<Integer> list = Lists.newArrayList(null, 1, null, 2, 3);
		List<Integer> listWithoutNulls = Lists.newArrayList(Iterables.filter(list, Predicates.notNull()));

		assertEquals(listWithoutNulls.size(), 3);
	}

	@Test
	public void givenListContainsNulls_whenRemovingNullsWithCommonsCollections_thenCorrect() {
		List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
		//CollectionUtils.filter(list, PredicateUtils.notNullPredicate());

		assertEquals(list.size(), 3);
	}

	// Classic JAVA
	@Test
	public void givenListContainsNulls_whenRemovingNullsWithPlainJava_thenCorrect() {
		List<Integer> list = Lists.newArrayList(null, 1, null);
		// List.of(null, 1, null); //at java.base/java.util.Objects.requireNonNull
		// MTS de ishlapdim
		while (list.remove(null))
			;

		assertEquals(list.size(), 1);
	}

	@Test
	public void givenListContainsNulls_whenRemovingNullsWithPlainJava_thenCorrect3() {
		List<Integer> list = Lists.newArrayList(null, 1, null);
		list.removeAll(Collections.singleton(null));
		assertEquals(list.size(), 1);
	}

	// Java 8
	@Test
	public void givenListContainsNulls_whenRemovingNullsWithPlainJava_thenCorrect2() {
		List<Integer> list = Lists.newArrayList(null, 1, null);
		List<Integer> nonNullObjs = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
		assertEquals(nonNullObjs.size(), 1);
	}

	@Test
	public void givenListContainsNulls_whenFilteringParallel_thenCorrect() {
		List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
		List<Integer> listWithoutNulls = list.parallelStream().filter(Objects::nonNull).collect(Collectors.toList());

		assertEquals(listWithoutNulls.size(), 3);
	}

	@Test
	public void givenListContainsNulls_whenFilteringSerial_thenCorrect() {
		List<Integer> list = Lists.newArrayList(null, 1, 2, null, 3, null);
		List<Integer> listWithoutNulls = list.stream().filter(Objects::nonNull).collect(Collectors.toList());

		assertEquals(listWithoutNulls.size(), 3);
	}

	public void givenListContainsNulls_whenRemovingNullsWithRemoveIf_thenCorrect() {
		List<Integer> listWithoutNulls = Lists.newArrayList(null, 1, 2, null, 3, null);
		listWithoutNulls.removeIf(Objects::isNull);

		assertEquals(listWithoutNulls.size(), 3);
	}

	private List<Integer> getFilledList() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(125);
		list.add(1);
		list.add(12);
		return list;
	}

	@Test
	public void removeByValueOrIndex() {
		// given
		final List<Integer> list = getFilledList();

		int valueToRemove = 1;
		/**
		 * In the test above we always call list.remove(1), but the element's index we
		 * want to remove is 0. Calling List.remove() shifts all elements after the
		 * removed one to smaller indices.
		 */

		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			System.out.println(list);
			removeAllIssueProne(list, valueToRemove);
			System.out.println(list);
		});

		System.out.println(list);
		assertEquals(list.size(), 1);

		System.out.println(
				"Note, that we face this problem only if we call List.remove() with a primitive byte, short, char or int argument, \n"
						+ "since the first thing the compiler does when it tries to find the matching overloaded method, is widening.");

		System.out.println("CORRECTIOn");

		final List<Integer> list2 = getFilledList();
		System.out.println(list2);

		removeAllOK(list2, valueToRemove);
		System.out.println(list2);

		assertEquals(list2.size(), 4);

		final List<Integer> list3 = getFilledList();
		System.out.println(list3);

		removeAllOKMine(list3, valueToRemove);
		System.out.println(list3);

		assertEquals(list3.size(), 4);

	}

	/**
	 * However, it doesn't work as expected:
	 * 
	 * The problem is when we call List.remove(int), when it treats its argument as
	 * the index, not the value we want to remove.
	 * 
	 * @param list
	 * @param element
	 */
	private void removeAllIssueProne(List<Integer> list, int element) {
		while (list.contains(element)) {
			/**
			 * In the test above we always call list.remove(1), but the element's index we
			 * want to remove is 0. Calling List.remove() shifts all elements after the
			 * removed one to smaller indices.
			 */
			/*
			 * Note, that we face this problem only if we call List.remove() with a
			 * primitive byte, short, char or int argument, since the first thing the
			 * compiler does when it tries to find the matching overloaded method, is
			 * widening.
			 */
			list.remove(element);
		}
	}

	private void removeAllOK(List<Integer> list, Integer element) {
		int index;
		while ((index = list.indexOf(element)) >= 0) {
			// removes by index, so first element will be removed
			list.remove(index);
		}
	}

	private void removeAllOKMine(List<Integer> list, Integer element) {
		while (list.contains(element)) {
			// removes an OBJECT
			list.remove((Integer) element);
		}
	}

	@Test
	public void removeUntillFinish() {
		// given
		final List<Integer> list = getFilledList();

		int valueToRemove = 1;
		System.out.println(list);
		removeAllTraverse(list, valueToRemove);
		System.out.println(list);
		assertEquals(list.size(), 4);

	}

	private void removeAllTraverse(List<Integer> list, Integer element) {
		while (list.remove(element))
			;
	}

	// may cause still an issue
	private void removeAll2(List<Integer> list, int element) {
		for (int i = 0; i < list.size(); i++) {
			if (Objects.equals(element, list.get(i))) {
				list.remove(i);
			}
		}
	}

	@Test
	public void removeViaIterator() {
		// given
		final List<Integer> list = getFilledList();

		int valueToRemove = 1;
		System.out.println(list);
		removeAllViaIterator(list, valueToRemove);
		System.out.println(list);
		assertEquals(list.size(), 4);

	}

	private void removeAllViaIterator(List<Integer> list, int element) {
		for (Iterator<Integer> i = list.iterator(); i.hasNext();) {
			Integer number = i.next();
			if (Objects.equals(number, element)) {
				i.remove();
			}
		}
	}

	@Test
	public void removeViaStream() {
		// given
		final List<Integer> list = getFilledList();

		int valueToRemove = 1;
		System.out.println(list);
		List<Integer> newList = removeAllViaStream(list, valueToRemove);
		System.out.println(newList);
		assertEquals(newList.size(), 4);

	}

	private List<Integer> removeAllViaStream(List<Integer> list, int element) {
		return list.stream().filter(e -> !Objects.equals(e, element)).collect(Collectors.toList());
	}

	@Test
	public void removeViaRemoveIf() {
		// given
		final List<Integer> list = getFilledList();

		int valueToRemove = 1;
		System.out.println(list);
		removeAllByRemoveIf(list, valueToRemove);
		System.out.println(list);
		assertEquals(list.size(), 4);

	}

	private void removeAllByRemoveIf(List<Integer> list, int element) {
		list.removeIf(n -> Objects.equals(n, element));
	}
	
	

	@Test
	public void whenIteratingTreeSet_shouldIterateTreeSetInAscendingOrder() {
		System.out.println("Set, Map  Those iterators are fail-fast.");
		Set<String> treeSet = new TreeSet<>();
		treeSet.add("First");
		treeSet.add("Second");
		treeSet.add("Third");
		Iterator<String> itr = treeSet.iterator();
		while (itr.hasNext()) {

			// itr.remove(); //java.lang.IllegalStateException
			System.out.println(itr.next());
			itr.remove();// OK
		}
		System.out.println(treeSet);
	}

	/**
	 * The Iterator throws a ConcurrentModificationException if the set is modified
	 * at any time after the iterator is created in any way except through the
	 * iterator's remove() method.
	 */
	@Test
	public void whenModifyingTreeSetWhileIterating_shouldThrowException() {
		Assertions.assertThrows(ConcurrentModificationException.class, () -> {
			Set<String> treeSet = new TreeSet<>();
			treeSet.add("First");
			treeSet.add("Second");
			treeSet.add("Third");
			Iterator<String> itr = treeSet.iterator();
			while (itr.hasNext()) {
				itr.next();
				treeSet.remove("Second");
			}
		});

	}

}
