package collection.baeldung.modernjava;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.Data;

//https://www.baeldung.com/java-tree-set
/**
 * Simply put, the TreeSet is a sorted collection that extends the AbstractSet
 * class and implements the NavigableSet interface.
 * 
 * <pre>
 * Here's a quick summary of the most important aspects of this implementation:
	
	It stores unique elements
	It doesn't preserve the insertion order of the elements
	It sorts the elements in ascending order
	It's not thread-safe
 * </pre>
 *
 * TreeSet uses a self-balancing binary search tree, more specifically a
 * Red-Black tree.
 */
public class TreeSetInJava {

	@Test
	public void whenAddingElement_shouldAddElement() {

		Set<String> treeSet = new TreeSet<>();
		Set<String> treeSet2 = new TreeSet<>(Comparator.comparing(String::length));
		/**
		 * Although TreeSet isn't thread-safe, it can be synchronized externally using
		 * the Collections.synchronizedSet() wrapper:
		 */
		Set<String> syncTreeSet = Collections.synchronizedSet(treeSet);

		/**
		 * The add method is extremely important as the implementation details of the
		 * method illustrate how the TreeSet works internally, how it leverages the
		 * TreeMap's put method to store the elements:
		 * 
		 * public boolean add(E e) { return m.put(e, PRESENT) == null; }
		 * 
		 * Therefore, the TreeSet internally depends on a backing NavigableMap which
		 * gets initialized with an instance of TreeMap when an instance of the TreeSet
		 * is created:
		 */
		assertTrue(treeSet.add("String Added"));
	}

	/**
	 * The contains() method is used to check if a given element is present in a
	 * given TreeSet. If the element is found, it returns true, otherwise false.
	 */
	@Test
	public void whenCheckingForElement_shouldSearchForElement() {
		Set<String> treeSetContains = new TreeSet<>();
		treeSetContains.add("String Added");

		assertTrue(treeSetContains.contains("String Added"));
	}

	@Test
	public void whenRemovingElement_shouldRemoveElement() {
		Set<String> removeFromTreeSet = new TreeSet<>();
		removeFromTreeSet.add("String Added");

		assertTrue(removeFromTreeSet.remove("String Added"));
	}

	/*
	 * if we want to remove all the items from a set, we can use the clear() method:
	 */
	@Test
	public void whenClearingTreeSet_shouldClearTreeSet() {
		Set<String> clearTreeSet = new TreeSet<>();
		clearTreeSet.add("String Added");
		clearTreeSet.clear();

		assertTrue(clearTreeSet.isEmpty());
	}

	@Test
	public void whenCheckingTheSizeOfTreeSet_shouldReturnThesize() {
		Set<String> treeSetSize = new TreeSet<>();
		treeSetSize.add("String Added");

		assertEquals(1, treeSetSize.size());
	}

	@Test
	public void whenCheckingForEmptyTreeSet_shouldCheckForEmpty() {
		Set<String> emptyTreeSet = new TreeSet<>();

		assertTrue(emptyTreeSet.isEmpty());
	}

	/**
	 * The iterator() method returns an iterator iterating in the ascending order
	 * over the elements in the Set. Those iterators are fail-fast.
	 */
	@Test
	public void whenIteratingTreeSet_shouldIterateTreeSetInAscendingOrder() {
		System.out.println(
				"Set, Map  Those iterators are fail-fast.  There's no guarantee on the fail-fast behavior of an iterator as it's impossible to make any hard guarantees in the presence of unsynchronized concurrent modification.");
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

	@Test
	public void whenIteratingTreeSet_shouldIterateTreeSetInDescendingOrder() {
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("First");
		treeSet.add("Second");
		treeSet.add("Third");
		Iterator<String> itr = treeSet.descendingIterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	/**
	 * The Iterator throws a ConcurrentModificationException if the set is modified
	 * at any time after the iterator is created in any way except through the
	 * iterator's remove() method.
	 */
	@Test
	public void whenModifyingTreeSetWhileIterating_shouldThrowException() {
		System.out.println("The Iterator throws a ConcurrentModificationException ..");

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

	@Test
	public void whenRemovingElementUsingIterator_shouldRemoveElement() {
		System.out.println(
				"Set, Map  Those iterators are fail-fast.  There's no guarantee on the fail-fast behavior of an iterator as it's impossible to make any hard guarantees in the presence of unsynchronized concurrent modification.");

		Set<String> treeSet = new TreeSet<>();
		treeSet.add("First");
		treeSet.add("Second");
		treeSet.add("Third");
		Iterator<String> itr = treeSet.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			if (element.equals("Second"))
				itr.remove();
		}

		System.out.println(treeSet);
		assertEquals(2, treeSet.size());
	}

	/**
	 * TreeSet first() This method returns the first element from a TreeSet if it's
	 * not empty. Otherwise, it throws a NoSuchElementException.
	 */
	@Test
	public void whenCheckingFirstElement_shouldReturnFirstElement() {
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("First");

		assertEquals("First", treeSet.first());

		Assertions.assertThrows(NoSuchElementException.class, () -> {
			Set<String> treeSet2 = new TreeSet<>();
			assertEquals("First", ((TreeSet<String>) treeSet2).first());
		});
	}

	@Test
	public void whenCheckingLastElement_shouldReturnLastElement() {
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("First");
		treeSet.add("Last");

		assertEquals("Last", treeSet.last());

		Assertions.assertThrows(NoSuchElementException.class, () -> {
			Set<String> treeSet2 = new TreeSet<>();
			assertEquals("First", ((TreeSet<String>) treeSet2).first());
		});
	}

	@Test
	public void whenUsingSubSet_shouldReturnSubSetElements() {
		SortedSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(4);
		treeSet.add(5);
		treeSet.add(6);

		Set<Integer> expectedSet = new TreeSet<>();
		expectedSet.add(2);
		expectedSet.add(3);
		expectedSet.add(4);
		expectedSet.add(5);

		Set<Integer> subSet = treeSet.subSet(2, 6);
		System.out.println(subSet);

		assertEquals(expectedSet, subSet);
		assertNotSame(expectedSet, subSet);
		org.junit.Assert.assertEquals(expectedSet, subSet);
	}

	@Test
	public void whenUsingHeadSet_shouldReturnHeadSetElements() {
		SortedSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(4);
		treeSet.add(5);
		treeSet.add(6);

		Set<Integer> subSet = treeSet.headSet(6);

		assertEquals(subSet, treeSet.subSet(1, 6));
	}

	@Test
	public void whenUsingTailSet_shouldReturnTailSetElements() {
		NavigableSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(4);
		treeSet.add(5);
		treeSet.add(6);

		Set<Integer> subSet = treeSet.tailSet(3);

		assertEquals(subSet, treeSet.subSet(3, true, 6, true));
	}

	/**
	 * Before Java 7, it was possible to add null elements to an empty TreeSet.
	 * 
	 * However, that was considered a bug. Therefore, TreeSet no longer supports the
	 * addition of null.
	 * 
	 * When we add elements to the TreeSet, the elements get sorted according to
	 * their natural order or as specified by the comparator. Hence adding a null,
	 * when compared to existing elements, results in a NullPointerException since
	 * null cannot be compared to any value:
	 * 
	 */
	@Test
	public void whenAddingNullToNonEmptyTreeSet_shouldThrowException() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			System.out
					.println("Before Java 7, it was possible to add null elements to an empty TreeSet.\r\n" + "	 * \r\n"
							+ "	 * However, that was considered a bug. Therefore, TreeSet no longer supports the\r\n"
							+ "	 * addition of null.");
			Set<String> treeSet = new TreeSet<>();
			treeSet.add("First");
			treeSet.add(null);
		});

		System.out.println(
				"\n Elements inserted into the TreeSet must either implement the Comparable interface or . \r\n\" +"
						+ " at least be accepted by the specified comparator.");

	}

	@Data
	class Element {
		private Integer id;
	}

	Comparator<Element> comparator = (ele1, ele2) -> {
		return ele1.getId().compareTo(ele2.getId());
	};

	@Test
	public void whenUsingComparator_shouldSortAndInsertElements() {
		Set<Element> treeSet = new TreeSet<>(comparator);
		Element ele1 = new Element();
		ele1.setId(100);
		Element ele2 = new Element();
		ele2.setId(200);

		treeSet.add(ele1);
		treeSet.add(ele2);

		System.out.println(treeSet);
	} 

}
