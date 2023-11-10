package collection.baeldung.modernjava;

import static org.junit.Assert.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

//https://www.baeldung.com/java-test-a-list-for-ordinality-and-equality
public class CheckTwoListsEquality {
	/**
	 * List is an ordered data structure so the order of elements matters by design.
	 */
	@Test
	public void whenTestingForEquality_ShouldBeEqual() throws Exception {
		List<String> list1 = Arrays.asList("1", "2", "3", "4");
		List<String> list2 = Arrays.asList("1", "2", "3", "4");
		List<String> list3 = Arrays.asList("1", "2", "4", "3");

		assertEquals(list1, list2);
		assertNotSame(list1, list2);
		assertNotEquals(list1, list3);
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

}
