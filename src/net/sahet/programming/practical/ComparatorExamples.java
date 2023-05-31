package net.sahet.programming.practical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorExamples {

	public static void main(String[] args) {

		// Comparator
		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		// Java 8 Comparator
		Comparator<String> cmp2 = Comparator.comparingInt(String::length);
		// chained Comparator (in CGI 2013 tried by old way)
		Comparator<String> cmp3 = Comparator.comparingInt(String::length).thenComparing(String::lastIndexOf);
		System.out.println();

		List<Auto> list = new ArrayList<>(Arrays.asList(new Auto("Ford fusion", "1AA 5091", 5),
				new Auto("Togg", "0AA 5091", 5), new Auto("Skoda Fabia Combi", "8P0 8257", 5),
				new Auto("Toyata RAV4", "9AD 6998", 5), new Auto("Citroen C1", "ABC 164521", 5),
				new Auto("Volvo V40", "XYZ 201845", 5), new Auto("Citroen C1", "ABC 164521", 4),
				new Auto("Dodge", "KLM 845990", 2), new Auto("Dodge Ram", "KLM 845990", 3)));
		List<String> l = List.of("A", "B", "C"); // immutable you can't modify
		l = Arrays.asList("A", "Z", "M", "A", "C", "y", "b"); // java.lang.UnsupportedOperationException: remove
		ArrayList<String> ll = new ArrayList<>(l);

		// Java 8 Comparator
		// to use natural one, Object must implement Comparable
		System.out.println("Natural comparator via Comparable interface #compareTo");
		Collections.sort(list, Comparator.naturalOrder());
		list.stream().forEach(System.out::println);
		System.out.println();

		System.out.println("Comparator via Comparator interface#compare() - Auto::getBrand");
		Comparator<Auto> comparatorByBrand = Comparator.comparing(Auto::getBrand);
		Collections.sort(list, comparatorByBrand);
		list.stream().forEach(System.out::println);
		System.out.println();
		
		// chained Comparator (in CGI 2013 tried by old way)
		System.out.println("Comparator via CGI 2013 tried by old way but now Java 8 way");
		Comparator<Auto> comparatorByBrandAndDoors = Comparator.comparing(Auto::getNumberPlate)
				.thenComparing(Auto::getBrand).thenComparing(Auto::getNoOfDoors);
		Collections.sort(list, comparatorByBrandAndDoors);
		list.stream().forEach(System.out::println);
		System.out.println();

		Comparator<Auto> comparatorByBrandAndDoorsReversed = comparatorByBrandAndDoors.reversed();
		Collections.sort(list, comparatorByBrandAndDoorsReversed);
		System.out.println(list);

		// or shorter
		Collections.sort(list, comparatorByBrand.reversed());
		System.out.println(list);

		System.out.println("Comparator nullsFirst");
		Comparator<String> nullsFirstCmp = Comparator.nullsFirst(Comparator.naturalOrder());
		l = Arrays.asList("A", null, "Z", "C", null); // List.of not allow nulls
		ll = new ArrayList<>(l);

		Collections.sort(ll, nullsFirstCmp);
		System.out.println(ll);

		Comparator<String> nullsLastCmp = Comparator.nullsLast(Comparator.naturalOrder());
		l = Arrays.asList("A", null, "Z", "C", null); // List.of not allow
		ll = new ArrayList<>(l);

		Collections.sort(ll, nullsLastCmp);
		System.out.println(ll);
	}

}

class Auto implements Comparable<Auto> {
	public String brand;
	public String numberPlate;
	public int noOfDoors;

	public Auto(String brand, String numberPlate, int noOfDoors) {
		this.brand = brand;
		this.numberPlate = numberPlate;
		this.noOfDoors = noOfDoors;
	}

	@Override
	public String toString() {
		return "Auto [brand=" + brand + ", numberPlate=" + numberPlate + ", noOfDoors=" + noOfDoors + "]";
	}

	public String getBrand() {
		return brand;
	}

	public String getNumberPlate() {
		return numberPlate;
	}

	public int getNoOfDoors() {
		return noOfDoors;
	}

	@Override
	public int compareTo(Auto o) {
		return numberPlate.compareTo(o.numberPlate);
	}

}
