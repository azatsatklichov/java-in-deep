package net.sahet.java.essentials.collections.streams.lambdas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class RemovingDuplicatesFromList {
	/**
	 * Remove Duplicates from a List Using Plain Java
	 */
s
	@Test
	public void givenListContainsDuplicates_whenRemovingDuplicatesWithPlainJava_thenCorrect() {
		List<Integer> listWithDuplicates = Lists.newArrayList(0, 1, 2, 3, 0, 0);
		System.out.println(listWithDuplicates);
		HashSet<Integer> set = new HashSet<>(listWithDuplicates);
		System.out.println(set);

		List<Integer> listWithoutDuplicates = new ArrayList<>(set);
		System.out.println(listWithoutDuplicates);

		assertEquals(listWithoutDuplicates.size(), 4);
	}

	/**
	 * Remove Duplicates from a List Using Guava
	 */
	@Test
	public void givenListContainsDuplicates_whenRemovingDuplicatesWithGuava_thenCorrect() {
		List<Integer> listWithDuplicates = Lists.newArrayList(0, 1, 2, 3, 0, 0);
		HashSet<Integer> set = Sets.newHashSet(listWithDuplicates);
		System.out.println(set);
		List<Integer> listWithoutDuplicates = Lists.newArrayList(set);

		assertEquals(listWithoutDuplicates.size(), 4);
	}

	/**
	 * remove Duplicates from a List Using Java 8 Lambdas
	 */

	@Test
	public void givenListContainsDuplicates_whenRemovingDuplicatesWithJava8_thenCorrect() {
		List<Integer> listWithDuplicates = Lists.newArrayList(1, 1, 2, 2, 3, 3);
		List<Integer> listWithoutDuplicates = listWithDuplicates.stream().distinct().collect(Collectors.toList());
		assertEquals(listWithoutDuplicates.size(), 3);
	}

}
