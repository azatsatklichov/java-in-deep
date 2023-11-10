package collection.baeldung.modernjava;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://www.baeldung.com/java-hashset
/***
 * Let's recall the most important aspects of this implementation:
 * 
 * 
 * <pre>
 *  
		It stores unique elements and permits nulls
		It's backed by a HashMap
		It doesn't maintain insertion order
		It's not thread-safe
		Note that this internal HashMap gets initialized when an instance of the HashSet is created:
 * </pre>
 * 
 * How HashSet Maintains Uniqueness?
 * 
 * Each hash code value corresponds to a certain bucket location which can
 * contain various elements, for which the calculated hash value is the same.
 * But two objects with the same hashCode might not be equal.
 * 
 * Performance
 * 
 * The performance of a HashSet is affected mainly by two parameters – its
 * Initial Capacity and the Load Factor.
 * 
 * The expected time complexity of adding an element to a set is O(1) which can
 * drop to O(n) in the worst case scenario (only one bucket present) –
 * therefore, it's essential to maintain the right HashSet's capacity.
 * 
 * An important note: since JDK 8, the worst case time complexity is O(log*n).
 */
public class HashSetInJava {

	/**
	 * From an implementation perspective, the add method is an extremely important
	 * one. Implementation details illustrate how the HashSet works internally and
	 * leverages the HashMap's put method:
	 * 
	 * It'd be a good idea to get familiar with the hashcode first to get a detailed
	 * understanding of how the elements are organized in hash-based data
	 * structures.
	 * 
	 * <pre>
	 * A HashMap is an array of buckets with a default capacity of 16 elements – each bucket corresponds to 
	 * a different hashcode value
	 * 
	If various objects have the same hashcode value, they get stored in a single bucket
	
	If the load factor is reached, a new array gets created twice the size of the previous one and all 
	elements get rehashed and redistributed among new corresponding buckets
	
	To retrieve a value, we hash a key, mod it, and then go to a corresponding bucket and search through 
	the potential linked list in case of there's more than a one object
	 * </pre>
	 */
	@Test
	public void whenAddingElement_shouldAddElement() {
		Set<String> hashset = new HashSet<>();

		assertTrue(hashset.add("String Added"));
	}

	@Test
	public void whenCheckingForElement_shouldSearchForElement() {
		Set<String> hashsetContains = new HashSet<>();
		hashsetContains.add("String Added");

		// String class has hashCode implemented, that is why below both found
		assertTrue(hashsetContains.contains("String Added"));
		assertTrue(hashsetContains.contains(new String("String Added")));

		assertFalse(hashsetContains.contains("String Added2"));
	}

	@Test
	public void whenRemovingElement_shouldRemoveElement() {
		Set<String> removeFromHashSet = new HashSet<>();
		removeFromHashSet.add("String Added");

		assertTrue(removeFromHashSet.remove("String Added"));
	}

	@Test
	public void whenClearingHashSet_shouldClearHashSet() {
		Set<String> clearHashSet = new HashSet<>();
		clearHashSet.add("String Added");
		clearHashSet.clear();

		assertTrue(clearHashSet.isEmpty());
	}

	@Test
	public void whenCheckingTheSizeOfHashSet_shouldReturnThesize() {
		Set<String> hashSetSize = new HashSet<>();
		hashSetSize.add("String Added");

		assertEquals(1, hashSetSize.size());
	}

	@Test
	public void whenCheckingForEmptyHashSet_shouldCheckForEmpty() {
		Set<String> emptyHashSet = new HashSet<>();

		assertTrue(emptyHashSet.isEmpty());
	}

	@Test
	public void whenIteratingHashSet_shouldIterateHashSet() {
		Set<String> hashset = new HashSet<>();
		hashset.add("First");
		hashset.add("Second");
		hashset.add("Third");
		Iterator<String> itr = hashset.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	/**
	 * If the set is modified at any time after the iterator is created in any way
	 * except through the iterator's own remove method, the Iterator throws a
	 * ConcurrentModificationException.
	 */
	@Test
	public void whenModifyingHashSetWhileIterating_shouldThrowException() {
		System.out.println("The Iterator throws a ConcurrentModificationException ..");

		/**
		 * The fail-fast behavior of an iterator cannot be guaranteed as it's impossible
		 * to make any hard guarantees in the presence of unsynchronized concurrent
		 * modification.
		 * 
		 * Fail-fast iterators throw ConcurrentModificationException on a best-effort
		 * basis. Therefore, it'd be wrong to write a program that depended on this
		 * exception for its correctness.
		 */
		Assertions.assertThrows(ConcurrentModificationException.class, () -> {

			Set<String> hashset = new HashSet<>();
			hashset.add("First");
			hashset.add("Second");
			hashset.add("Third");
			Iterator<String> itr = hashset.iterator();
			while (itr.hasNext()) {
				itr.next();
				hashset.remove("Second");
			}
		});
	}

	@Test
	public void whenRemovingElementUsingIterator_shouldRemoveElement() {

		Set<String> hashset = new HashSet<>();
		hashset.add("First");
		hashset.add("Second");
		hashset.add("Third");
		Iterator<String> itr = hashset.iterator();
		while (itr.hasNext()) {
			String element = itr.next();
			if (element.equals("Second"))
				itr.remove();
		}

		System.out.println(hashset);
		assertEquals(2, hashset.size());
	}

}
