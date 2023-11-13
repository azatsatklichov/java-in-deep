package net.sahet.java.essentials.collections.streams.lambdas;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingAndComparators {

	public static void main(String[] args) {

		// immutable
		List<String> l = Arrays.asList("Alma", "Zemmer", "Mollatorgay", "Makul", "akgyz", "Calasyn");
		// mutable list
		List<Auto> list = new ArrayList<>(
				Arrays.asList(new Auto("Skoda Fabia", "8P0 8257", 5), new Auto("Skoda Fabia", "8P0 8257", 5),
						new Auto("Citroen C1", "ABC 164521", 5), new Auto("Toyota RAV4", "9AD 6998", 5),
						new Auto("Volvo V40", "XYZ 201845", 5), new Auto("Citroen C1", "ABC 164521", 4),
						new Auto("Dodge", "KLM 845990", 2), new Auto("Dodge Ram", "KLM 845990", 3)));

		System.out.println(
				"\nNatural comparator - to use natural one, Object must implement Comparable #compareTo(T otherObj)");
		l.sort(Comparator.naturalOrder());// String - implements comparable comprateTo(string anotherStr) - by Alphabet
		// Consumer as a Parameter
		// l.stream().forEach(System.out::print);
		System.out.println(l);
		Collections.sort(list, Comparator.naturalOrder());// Auto - implements comparable comprateTo(Auto otherAuto) -
															// by Plate
		System.out.println(list);

		System.out.println("\nReverse comparator - still uses natural comparator here");
		l.sort(Comparator.reverseOrder());
		System.out.println(l);
		list.sort(Comparator.reverseOrder());
		System.out.println(list);

		System.out.println(
				"\nReverse Ordering - Returns a comparator that imposes the reverse of the naturalordering(sorting). ");
		String[] s = { "B", "C", "A" };
		System.out.println(Arrays.toString(s));
		Arrays.sort(s, Comparator.reverseOrder());
		System.out.println(Arrays.toString(s));

		Collections.sort(l, Comparator.reverseOrder());
		System.out.println(l);
		Collections.sort(list, Comparator.reverseOrder());
		System.out.println(list);

		System.out.println("\nComparator - classic custom implementation of Comparator#compare(o1, o2)");
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				boolean comp = o1.length() > o2.length();
				return comp ? 1 : o1.length() == o2.length() ? 0 : -1;
			}
		};
		// sort by length
		l.sort(cmp);
		System.out.println(l);
		// reverser order by length
		l.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				boolean comp = o1.length() > o2.length();
				return comp ? -1 : o1.length() == o2.length() ? 0 : 1;
			}
		});
		System.out.println(l);

		System.out.println("\nComparator - Java 8 lambda way - via Comparator interface#compare()");
		Comparator<String> cmp2 = Comparator.comparingInt(String::length);
		l.sort(cmp2);
		System.out.println(l);
		Comparator<Auto> comparatorByBrand = Comparator.comparing(Auto::getBrand);
		Collections.sort(list, comparatorByBrand);
		System.out.println(list);

		System.out.println("\nReverse comparator - uses comparator reversed() method here");
		l.sort(cmp.reversed());
		System.out.println(l);

		l.sort(cmp2.reversed());
		System.out.println(l);

		Collections.sort(list, comparatorByBrand.reversed());
		System.out.println(list);

		System.out.println(
				"\nChained Comparator - sort like SQL way[order by col1, col2 desc|asc]: length, then last index ");
		// chained Comparator (in CGI 2013 tried by old way)
		Comparator<String> compareByLengthAndLastIndex = Comparator.comparingInt(String::length)
				.thenComparing(String::lastIndexOf);
		l.sort(compareByLengthAndLastIndex);
		System.out.println(l);
		// reversed order
		l.sort(compareByLengthAndLastIndex.reversed());
		System.out.println(l);

		Comparator<Auto> comparatorByBrandAndDoors = Comparator.comparing(Auto::getBrand)
				.thenComparing(Auto::getNoOfDoors);
		Collections.sort(list, comparatorByBrandAndDoors);
		System.out.println(list);
		// reversed order
		Comparator<Auto> comparatorByBrandAndDoorsReversed = comparatorByBrandAndDoors.reversed();
		Collections.sort(list, comparatorByBrandAndDoorsReversed);
		System.out.println(list);

		System.out.println("\nComparator nulls First");
		Comparator<String> nullsFirstCmp = Comparator.nullsFirst(Comparator.naturalOrder());
		l = Arrays.asList("A", null, "Z", "C", null, null); // List.of not allow nulls
		Collections.sort(l, nullsFirstCmp);
		System.out.println(l);
		// reverse ordered
		nullsFirstCmp = Comparator.nullsFirst(Comparator.reverseOrder());
		Collections.sort(l, nullsFirstCmp);
		System.out.println(l);

		Comparator<Auto> nullsFirstAuto = Comparator.nullsFirst(Comparator.naturalOrder());
		// immutable list
		list = Arrays.asList(null, new Auto("Skoda Fabia", "8P0 8257", 5), new Auto("Skoda Fabia", "8P0 8257", 5),
				new Auto("Citroen C1", "ABC 164521", 5), new Auto("Toyota RAV4", "9AD 6998", 5),
				new Auto("Volvo V40", "XYZ 201845", 5), new Auto("Citroen C1", "ABC 164521", 4), null, null,
				new Auto("Dodge", "KLM 845990", 2), new Auto("Dodge Ram", "KLM 845990", 3));

		Collections.sort(list, nullsFirstAuto);
		System.out.println(list);

		System.out.println("\nComparator nulls Last");
		Comparator<String> nullsLastCmp = Comparator.nullsLast(Comparator.naturalOrder());
		Comparator<Auto> nullsLastAuto = Comparator.nullsLast(Comparator.naturalOrder());
		Collections.sort(l, nullsLastCmp);
		System.out.println(l);
		Collections.sort(list, nullsLastAuto);
		System.out.println(list);

		/*
		 * Below code throws below exception
		 * 
		 * 
		 * Exception in thread "main" java.lang.NullPointerException: Cannot read field
		 * "numberPlate" because "o" is null
		 * 
		 * TimSort complain & throw
		 */
		// Collections.sort(l, Comparator.reverseOrder());
		// NullPointerException
		// System.out.println(l);
		// Collections.sort(list, Comparator.reverseOrder());
		// System.out.println(list);

		System.out.println(
				"\nComparator.reverseOrder() on above code will throw a NullPointerException because specified list contains null value");
		System.out.println("You can easily modify the compare() method to handle nulls, as below");
		/*
		 * Exception in thread "main" java.lang.NullPointerException: Cannot read field
		 * "value" because "anotherString" is null
		 */

		CustomComparator<String> customStrNonNullComparator = new CustomComparator<>();
		nullsFirstCmp = Comparator.nullsFirst(customStrNonNullComparator);
		Collections.sort(l, nullsFirstCmp);
		System.out.println(l);
		Collections.sort(l, nullsFirstCmp.reversed());
		System.out.println(l);

		CustomComparator<Auto> customAutoNonNullComparator = new CustomComparator<>();
		nullsFirstAuto = Comparator.nullsFirst(customAutoNonNullComparator);
		Collections.sort(list, nullsFirstAuto);
		System.out.println(list);
		Collections.sort(list, nullsFirstAuto.reversed());
		System.out.println(list);

		System.out.println("\nUsing Guava Library");

		/**
		 * * Google’s Guava library provides static Ordering.natural().reverse() that
		 * returns an Ordering that uses the reverse order of the values.
		 * 
		 * https://www.techiedelight.com/reverse-order-comparator-guava-ordering-class/
		 * 
		 * <pre>
		 * Arrays.sort(s, Ordering.natural().reverse());
		 * System.out.println(Arrays.toString(s)); // [C, B, A]
		 * 
		 * The above code will throw a NullPointerException if the specified array contains any null value. 
		 * We can handle nulls using the nullsFirst() method that returns an ordering that considers null to be less than non-null values, as shown below
		 * 
		 * s = { "B", null, "C", "A", null };
		 * 
		 *  // put all null values before non-null values
		Arrays.sort(s, Ordering.natural().reverse().nullsFirst());
		
		// [null, null, C, B, A]
		System.out.println(Arrays.toString(s));
		
		// put all null values after all non-null values
		Arrays.sort(s, Ordering.natural().reverse().nullsLast());
		
		// [C, B, A, null, null]
		System.out.println(Arrays.toString(s));
		 * 
		 * </pre>
		 */

		System.out.println("\nUsing Apache Commons Collections");

		/**
		 * * Apache commons-collections provides static
		 * ComparatorUtils.reversedComparator() that returns a comparator that reverses
		 * the order of the specified comparator.
		 * 
		 * Reverse Order Comparators in Apache Commons Collections
		 * https://www.techiedelight.com/reverse-order-comparators-apache-commons-collections/
		 *
		 *
		 * String[] s = { "B", "C", "A" }; Arrays.sort(s,
		 * ComparatorUtils.reversedComparator(ComparatorUtils.NATURAL_COMPARATOR);
		 * System.out.println(Arrays.toString(s)); // [C, B, A]
		 * 
		 * or we can also call Comparator.reversed()
		 * 
		 * String[] s = { "B", "C", "A" }; Arrays.sort(s,
		 * ComparatorUtils.NATURAL_COMPARATOR.reversed());
		 * System.out.println(Arrays.toString(s)); // [C, B, A]
		 * 
		 * Using nullLowComparator() method
		 * 
		 * If the specified array contains any null value,
		 * ComparatorUtils.reversedComparator() will throw a NullPointerException
		 * 
		 * s = { "B", null, "C", "A", null };
		 * 
		 * // put all null values before non-null values Arrays.sort(s,
		 * ComparatorUtils.nullLowComparator(ComparatorUtils
		 * .naturalComparator().reversed()));
		 * 
		 * System.out.println(Arrays.toString(s));// [null, null, C, B, A]
		 * 
		 * Using nullHighComparator() method
		 * 
		 * method that returns a comparator that considers a null value to be greater
		 * than any non-null value and equal to any other null value:
		 * 
		 * // put all null values after all non-null values Arrays.sort(s,
		 * ComparatorUtils.nullHighComparator(ComparatorUtils
		 * .naturalComparator().reversed()));
		 * 
		 * 
		 * System.out.println(Arrays.toString(s));// [C, B, A, null, null]
		 * 
		 * 
		 * <pre>
		 *
		 * </pre>
		 */

	}

}

class CustomComparator<T extends Comparable<T>> implements Comparator<T> {

	/**
	 * To return a comparator that considers null to be less than non-null values (
	 * null to be less than non-null values)
	 * 
	 * Or for reverse order, just replace -1 with 1, and wise versa if you want To
	 * return a comparator that considers null to be greater than non-null values:
	 */
	@Override
	public int compare(T a, T b) {
		if (a == null && b == null) {
			return 0;
		}

		if (a == null) {
			return -1; // 1
		}

		if (b == null) {
			return 1;// -1
		}

		return b.compareTo(a);
	}
}


