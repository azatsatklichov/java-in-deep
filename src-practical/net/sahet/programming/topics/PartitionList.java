package net.sahet.programming.topics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.commons.collections4.ListUtils;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * https://www.baeldung.com/java-list-split
 */
public class PartitionList {

	/*
	 * Use Guava to Partition the List
	 */
	@Test
	public void givenList_whenParitioningIntoNSublistsViaGuava_thenCorrect() {
		System.out.println("\nKeep in mind that the partitions are sublist views of the original collection – which ");
		System.out.println("means that changes in the original collection will be reflected in the partitions:");
		List<Integer> intList = Lists.newArrayList(1, 2, -23, 4, 5, 6, 7, 8);
		List<List<Integer>> subSets = Lists.partition(intList, 3);
		System.out.println(subSets);

		List<Integer> lastPartition = subSets.get(2);
		System.out.println(lastPartition);
		List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(7, 8);
		System.out.println(expectedLastPartition);
		assertEquals(subSets.size(), 3);
		assertEquals(lastPartition, expectedLastPartition);
	}

	/*
	 * Use Guava to partition a Collection
	 */
	@Test
	public void givenCollection_whenParitioningIntoNSublistsViaGuava_thenCorrect() {

		System.out.println("\nKeep in mind that the partitions are sublist views of the original collection – which ");
		System.out.println("means that changes in the original collection will be reflected in the partitions:");
		Collection<Integer> intCollection = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);

		Iterable<List<Integer>> subSets = Iterables.partition(intCollection, 3);
		System.out.println(subSets);

		List<Integer> firstPartition = subSets.iterator().next();
		List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(1, 2, 3);
		assertEquals(firstPartition, expectedLastPartition);
	}

	/**
	 * The latest releases of Apache Commons Collections have recently added support
	 * for partitioning a List as well:
	 */
	@Test
	public void givenList_whenParitioningIntoNSublistsViaApacheCommonsCollections_thenCorrect() {
		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8);
		List<List<Integer>> subSets = ListUtils.partition(intList, 3);

		List<Integer> lastPartition = subSets.get(2);
		List<Integer> expectedLastPartition = List.of(7, 8);

		assertEquals(subSets.size(), 3);
		assertEquals(lastPartition, expectedLastPartition);
	}

	/**
	 * Use Java8 to Partition the List
	 */
	@Test
	public void givenList_whenParitioningIntoSublistsUsingPartitionBy_thenCorrect() {
		List<Integer> intList = List.of(1, 2, 3, 4, 5, 6, 7, 8);

		System.out.println("\n   Java 8 Collectors.partitioningBy() to split our list to multiple partitions");
		System.out.println("Note: The resulting partitions are not a view of the main List, so any changes "
				+ "happen to the main List won't affect the partitions.");
		Map<Boolean, List<Integer>> groups = intList.stream().collect(Collectors.partitioningBy(s -> s > 6));

		System.out.println(intList);
		System.out.println(groups);
		List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());

		List<Integer> lastPartition = subSets.get(1);
		List<Integer> expectedLastPartition = List.of(7, 8);
		assertEquals(subSets.size(), 2);
		assertEquals(lastPartition, expectedLastPartition);
	}

	/*
	 * We also can use Collectors.groupingBy() to split our list to multiple
	 * partitions:
	 */
	@Test
	public void givenList_whenParitioningIntoNSublistsUsingGroupingBy_thenCorrect() {

		System.out.println("\n   Java 8 Collectors.groupingBy() to split our list to multiple partitions");
		System.out.println(
				"Note: Just as Collectors.partitioningBy() – the resulting partitions won't be affected by changes in main List.");
		List<Integer> intList = List.of(1, 22, 3, 24, 27, 3, 4, 6, 7, 8);

		/* group by same divisibility */
		Map<Integer, List<Integer>> groups = intList.stream().collect(Collectors.groupingBy(s -> (s - 1) / 3));

		System.out.println(intList);
		System.out.println(groups);
		Map<Integer, List<Integer>> group2 = intList.stream().collect(Collectors.groupingBy(s -> s % 2));
		System.out.println(group2);

		List<String> positions = List.of("FullStack", "Senior Java", "Senior Javascript", "Junor Java", "Senior Java");
		Map<String, List<String>> selected = positions.stream()
				.collect(Collectors.groupingBy(x -> x.contains("Java") ? x : x));
		System.out.println(selected);

		List<List<Integer>> subSets = new ArrayList<List<Integer>>(groups.values());

		List<Integer> lastPartition = subSets.get(2);
		List<Integer> expectedLastPartition = List.of(7, 8);
		assertEquals(subSets.size(), 5);
		assertEquals(lastPartition, expectedLastPartition);
	}

	/**
	 * We can also use Java8 to split our List by separator:
	 */
	@Test
	public void givenList_whenSplittingBySeparator_thenCorrect() {

		System.out.println("\n   Java 8 Split the List by Separator: "
				+ "\nNote: We used “0�? as separator – we first obtained the indices of all “0�? elements in the List, "
				+ "then we split the List on these indices.");
		List<Integer> intList = List.of(1, 2, 3, 0, 4, 5, 6, 0, 7, 8);

		int[] indexes = Stream.of(IntStream.of(-1), IntStream.range(0, intList.size()).filter(i -> intList.get(i) == 0),
				IntStream.of(intList.size())).flatMapToInt(s -> s).toArray();

		System.out.println(Arrays.toString(indexes));
		List<List<Integer>> subSets = IntStream.range(0, indexes.length - 1)
				.mapToObj(i -> intList.subList(indexes[i] + 1, indexes[i + 1])).collect(Collectors.toList());
		System.out.println(subSets);

		List<Integer> lastPartition = subSets.get(2);
		List<Integer> expectedLastPartition = List.of(7, 8);

		assertEquals(subSets.size(), 3);
		assertEquals(lastPartition, expectedLastPartition);
	}

}
