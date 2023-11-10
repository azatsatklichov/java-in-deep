package collection.baeldung.modernjava;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://www.baeldung.com/java-treemap
/***
 * TreeMap is a map implementation that keeps its entries sorted according to
 * the natural ordering of its keys or better still using a comparator if
 * provided by the user at construction time.
 * 
 * 
 * <pre>
 * Internal Implementation of TreeMap
TreeMap implements NavigableMap interface and bases it's internal working on the principles of red-black trees:

1
2
public class TreeMap<K,V> extends AbstractMap<K,V>
  implements NavigableMap<K,V>, Cloneable, java.io.Serializable
The principle of red-black trees is beyond the scope of this article, however, there are key things to remember in order to understand how they fit into TreeMap.

First of all, a red-black tree is a data structure that consists of nodes; picture an inverted mango tree with its root in the sky and the branches growing downward. The root will contain the first element added to the tree.

The rule is that starting from the root, any element in the left branch of any node is always less than the element in the node itself. Those on the right are always greater. What defines greater or less than is determined by the natural ordering of the elements or the defined comparator at construction as we saw earlier.

This rule guarantees that the entries of a treemap will always be in sorted and predictable order.

Secondly, a red-black tree is a self-balancing binary search tree. This attribute and the above guarantee that basic operations like search, get, put and remove take logarithmic time O(log n).

Being self-balancing is key here. As we keep inserting and deleting entries, picture the tree growing longer on one edge or shorter on the other.

This would mean that an operation would take a shorter time on the shorter branch and longer time on the branch which is furthest from the root, something we would not want to happen.

Therefore, this is taken care of in the design of red-black trees. For every insertion and deletion, the maximum height of the tree on any edge is maintained at O(log n) i.e. the tree balances itself continuously.
 * </pre>
 */
public class TreeMapInJava {

	@Test
	public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect() {
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(3, "val");
		map.put(2, "val");
		map.put(1, "val");
		map.put(5, "val");
		map.put(4, "val");

		assertEquals("[1, 2, 3, 4, 5]", map.keySet().toString());
	}

	@Test
	public void givenTreeMap_whenOrdersEntriesNaturally_thenCorrect2() {
		TreeMap<String, String> map = new TreeMap<>();
		map.put("c", "val");
		map.put("b", "val");
		map.put("a", "val");
		map.put("e", "val");
		map.put("d", "val");

		assertEquals("[a, b, c, d, e]", map.keySet().toString());
	}

	/**
	 * Custom Sorting in TreeMap
	 * 
	 * If we're not satisfied with the natural ordering of TreeMap, we can also
	 * define our own rule for ordering by means of a comparator during construction
	 * of a tree map.
	 * 
	 * In the example below, we want the integer keys to be ordered in descending
	 * order:
	 */
	@Test
	public void givenTreeMap_whenOrdersEntriesByComparator_thenCorrect() {
		TreeMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
		map.put(3, "val");
		map.put(2, "val");
		map.put(1, "val");
		map.put(5, "val");
		map.put(4, "val");

		assertEquals("[5, 4, 3, 2, 1]", map.keySet().toString());
	}

	@Test
	public void givenTreeMap_whenPerformsQueries_thenCorrect() {
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(3, "val");
		map.put(2, "val");
		map.put(1, "val");
		map.put(5, "val");
		map.put(4, "val");

		Integer highestKey = map.lastKey();
		Integer lowestKey = map.firstKey();
		Set<Integer> keysLessThan3 = map.headMap(3).keySet();
		Set<Integer> keysGreaterThanEqTo3 = map.tailMap(3).keySet();

		assertEquals(new Integer(5), highestKey);
		assertEquals(new Integer(1), lowestKey);
		assertEquals("[1, 2]", keysLessThan3.toString());
		assertEquals("[3, 4, 5]", keysGreaterThanEqTo3.toString());
	}
 

}
