package net.sahet.java.essentials.collections.streams.lambdas;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * https://www.baeldung.com/java-remove-first-element-from-list
 *
 * <pre>
 *Although the methods look similar, their efficiency differs. ArrayList‘s remove() method requires O(n) time, 
 *whereas LinkedList‘s removeFirst() method requires O(1) time.

This is because ArrayList uses an array under the hood, and the remove() operation requires copying the 
rest of the array to the beginning. The larger the array is, the more elements need to be shifted.

Unlike that, LinkedList uses pointers meaning that each element points to the next and the previous one.

Hence, removing the first element means just changing the pointer to the first element. This operation
 always requires the same time not depending on the size of a list.
 * </pre>
 */s
public class RemoveFirstElmsFromList {

	private List<String> list = new ArrayList<>();
	private List<String> linkedList = new LinkedList<>();

	@BeforeEach
	public void init() {
		list.add("cat");
		list.add("dog");
		list.add("pig");
		list.add("cow");
		list.add("goat");

		linkedList.add("cat");
		linkedList.add("dog");
		linkedList.add("pig");
		linkedList.add("cow");
		linkedList.add("goat");
	}

	@Test
	public void givenList_whenRemoveFirst_thenRemoved() {
		// O(N) time
		list.remove(0);

		assertEquals(list.size(), 4);
		assertFalse(list.contains("cat"));
	}

	@Test
	public void givenLinkedList_whenRemoveFirst_thenRemoved() {
		// O(1) time
		((LinkedList<String>) linkedList).removeFirst();

		assertEquals(linkedList.size(), 4);
		assertFalse(linkedList.contains("cat"));
	}


}
