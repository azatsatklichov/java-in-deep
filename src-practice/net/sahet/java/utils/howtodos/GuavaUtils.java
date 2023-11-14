package net.sahet.java.utils.howtodos;

import java.util.Arrays;

import com.google.common.collect.Ordering;

public class GuavaUtils {

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

	}

}
