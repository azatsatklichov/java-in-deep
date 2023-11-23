package net.sahet.java.essentials.collections.streams.lambdas;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class IntersectionOfTwoLists {

	@Test
	public void givenList_whenRemoveFirst_thenRemoved() {

		List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
		List<String> otherList = Arrays.asList("red", "green", "green", "yellow");

		// Valo da CIL da edipdim
		/**
		 * First, we remove the duplicated elements with distinct. Then, we use the
		 * filter to select the elements that are also contained in the otherList.
		 */
		Set<String> result = list.stream().distinct().filter(otherList::contains).collect(Collectors.toSet());

		Set<String> commonElements = new HashSet(Arrays.asList("red", "green"));

		assertEquals(commonElements, result);
		assertFalse(list.contains("cat"));
	} 
}
