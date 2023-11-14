package net.sahet.java.utils.howtodos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Ordering;

public class CommonsLangIOUtils {
	@Test
	public void whenUsingCommonsIO_thenFileData() throws IOException {
		String expectedData = "palin duzuw bolsyn";
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("fileinclasspath2.txt").getFile());
		String data = FileUtils.readFileToString(file, "UTF-8");
		assertEquals(expectedData, data);
	}

	public static void main(String[] args) {
		System.out.println("\nUsing Guava Library");

		/**
		 * * Google’s Guava library provides static Ordering.natural().reverse() that
		 * returns an Ordering that uses the reverse order of the values.
		 * 
		 * https://www.techiedelight.com/reverse-order-comparator-guava-ordering-class/
		 * </pre>
		 */
		String[] g = { "B", "C", "A" };
		Arrays.sort(g, Ordering.natural().reverse());
		System.out.println(Arrays.toString(g)); // [C, B, A]

		String[] g1 = { "B", null, "C", "A", null };

		// put all null values before non-null values
		Arrays.sort(g1, Ordering.natural().reverse().nullsFirst());

		// [null, null, C, B, A]
		System.out.println(Arrays.toString(g1));
		String[] g2 = { "B", null, "C", "A", null };

		// put all null values after all non-null values
		Arrays.sort(g2, Ordering.natural().reverse().nullsLast());

		// [C, B, A, null, null]
		System.out.println(Arrays.toString(g2));

		// Using Custom Ordering
		String[] sj = { "B", "C", "A" };
		Arrays.sort(sj, new Ordering<>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
		System.out.println(Arrays.toString(sj)); // [C, B, A]

		System.out.println("\nUsing Apache Commons Collections");

		/**
		 * * Apache commons-collections provides static
		 * 
		 * https://www.techiedelight.com/reverse-order-comparators-apache-commons-collections/
		 *
		 *
		 */
		String[] sz = { "B", "C", "A" };
		System.out.println(Arrays.toString(sz));
		Arrays.sort(sz, ComparatorUtils.reversedComparator(ComparatorUtils.NATURAL_COMPARATOR));
		System.out.println(Arrays.toString(sz)); // [C, B, A]

		// Using nullLowComparator() method
		/*
		 * If the specified array contains any null value,
		 * ComparatorUtils.reversedComparator() will throw a NullPointerException
		 */
		String[] sz2 = { "B", null, "C", "A", null };

		// put all null values before non-null values Arrays.sort(s,
		Arrays.sort(sz2, ComparatorUtils.nullLowComparator(ComparatorUtils.naturalComparator().reversed()));
		System.out.println(Arrays.toString(sz2));// [null, null, C, B, A]

		// Using nullHighComparator() method
		/*
		 * method that returns a comparator that considers a null value to be greater
		 * than any non-null value and equal to any other null value:
		 */

		// put all null values after all non-null values Arrays.sort(s,
		Arrays.sort(sz2, ComparatorUtils.nullHighComparator(ComparatorUtils.naturalComparator().reversed()));
		System.out.println(Arrays.toString(sz2));// [C, B, A, null, null]
	}

}
