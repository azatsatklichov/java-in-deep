package net.sahet.java.essentials.collections.streams.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionsAndMaps {

	public static void main(String[] args) {
		System.out.println("lists");
		List<String> l = List.of("A", "B", "C"); // immutable list you can't modify
		l.stream().forEach(System.out::print);
		System.out.println();

		l = Arrays.asList("A", "Z", "M", "M", "a", "C");
		// l.remove(2);// java.lang.UnsupportedOperationException: remove

		// use classic list
		ArrayList<String> ll = new ArrayList<>(l);
		System.out.println(ll);
		ll.remove(2);
		System.out.println(ll);
		ll.removeIf(x -> "A".equalsIgnoreCase(x));
		System.out.println(ll);
		ll.replaceAll(String::toLowerCase);
		System.out.println(ll);

		System.out.println("\nmaps");
		Map<String, Auto> maps = new HashMap<>();
		maps.put("citroen", new Auto("Citroen C1", "ABC 164521", 4));
		Auto myFord = new Auto("Frod Fusion", "1AA 5091", 5);
		maps.put("ford", myFord);
		Auto myFabia = new Auto("Skoda Fabia", "8P0 8257", 5);
		maps.put("fabia", myFabia);
		Auto myRav4 = new Auto("Toyota RAV4", "9AD 6998", 5);
		maps.put("rav4", myRav4);
		maps.put("dodge", new Auto("Dodge Ram", "KLM 845990", 3));

		// BiConsumer as a Parameter
		maps.forEach((k, v) -> System.out.println(k + "=" + v));
		// maps.forEach(System.out::print); can't

		System.out.println("\ngetOrDefault");
		// if no key exist provide default one
		Auto defaultAuto = new Auto("Skoda Fabia", "8P0 8257", 5);
		Auto auto = maps.getOrDefault("ford", defaultAuto);
		System.out.println("Auto|defaultAuto = " + auto);
		auto = maps.getOrDefault("fordy", defaultAuto);
		System.out.println("Auto|defaultAuto = " + auto);

		System.out.println("\nput and putIfAbsent");
		System.out.println("Auto = " + maps.get("dodge"));
		// erases existing one, and replace the value with new
		Auto z = new Auto("Dodge RammmZ", "zKLM 845990", 3);
		maps.put("dodge", z);
		maps.put("dodge2", z);
		System.out.println("Auto = " + maps.get("dodge"));
		// put if absent, so no replace happens
		Auto z2 = new Auto("Dodge RammmZ2", "z2KLM 845990", 3);
		maps.putIfAbsent("dodge", z2);
		System.out.println("Auto = " + maps.get("dodge"));
		System.out.println();

		System.out.println("\nreplace - classic");
		System.out.println("Auto = " + maps.get("dodge"));
		Auto zam = new Auto("Dodge RammmZAM", "zamKLM 845990", 3);
		Auto newZam = new Auto("Dodge New", "new 845990", 3);
		maps.replace("dodge", zam);
		System.out.println("Auto replaced = " + maps.get("dodge"));
		// only replaces if old value exists
		System.out.println("\nreplace - happens only on that key if old value exists");
		maps.replace("dodge", null, newZam); // or give some different value not mapped to key
		System.out.println("Auto not replaced with new = " + maps.get("dodge"));
		maps.replace("dodge", zam, newZam);
		System.out.println("Auto replaced with new = " + maps.get("dodge"));

		System.out.println("\nremove - classic");
		// remove before Java 8
		System.out.println("Auto = " + maps.get("dodge"));
		maps.remove("dodge");
		System.out.println("Auto = " + maps.get("dodge"));
		System.out.println("\nremove - happens only on that key if old value exists");
		// remove Java 8
		maps.remove("dodge2", zam);// zam or null, then no remove happens, simply checks if value is mapped to key
		System.out.println("Auto = " + maps.get("dodge2"));
		maps.remove("dodge2", z); // removes
		System.out.println("Auto = " + maps.get("dodge2"));

		System.out.println("replaceAll");
		maps.replaceAll((k, v) -> myFord);
		System.out.println(maps);

	}

}




//https://www.baeldung.com/java-collections
class JavaCollections {s
	public static void main(String[] args) {

		System.out.println("Multi Dimensional ArrayList");
		int vertexCount = 3;
		// We can represent the edges in a 2-D ArrayList by creating and populating an
		// ArrayList of ArrayLists.
		twoDimensional(vertexCount);

		System.out.println("\n  Three-Dimensional ArrayList");
		// let's first initialize the variables and the 3-D ArrayList:
		threeDimensional();

		System.out.println("\n Converting Iterator to List");
		Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
		List<Integer> actualList = new ArrayList<Integer>();
		while (iterator.hasNext()) {
			actualList.add(iterator.next());
		}

		System.out.println("\n  Using Java 8 Iterator.forEachRemaining");
		actualList = List.of(23, -44, 33, 67); // new ArrayList<Integer>();
		iterator.forEachRemaining(actualList::add);
		System.out.println(actualList);

	}

	private static void twoDimensional(int vertexCount) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);
		for (int i = 0; i < vertexCount; i++) {
			graph.add(new ArrayList());
		}
		graph.get(0).add(1);
		graph.get(1).add(2);
		graph.get(2).add(0);

		vertexCount = graph.size();
		for (int i = 0; i < vertexCount; i++) {
			int edgeCount = graph.get(i).size();
			for (int j = 0; j < edgeCount; j++) {
				Integer startVertex = i;
				Integer endVertex = graph.get(i).get(j);
				System.out.printf("Vertex %d is connected to vertex %d%n", startVertex, endVertex);
			}
		}
	}

	private static void threeDimensional() {
		int x_axis_length = 2;
		int y_axis_length = 2;
		int z_axis_length = 2;
		ArrayList<ArrayList<ArrayList<String>>> space = new ArrayList<>(x_axis_length);
		for (int i = 0; i < x_axis_length; i++) {
			space.add(new ArrayList<ArrayList<String>>(y_axis_length));
			for (int j = 0; j < y_axis_length; j++) {
				space.get(i).add(new ArrayList<String>(z_axis_length));
			}
		}
		space.get(0).get(0).add(0, "Red");
		space.get(0).get(0).add(1, "Red");
	}

	@Test 
	public void whenIterateOverItAndTryToRemoveElement_thenShouldThrowException() {

		Assertions.assertThrows(UnsupportedOperationException.class, () -> {
		CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[] { 1, 3, 5, 8 });

		Iterator<Integer> iterator = numbers.iterator();
		while (iterator.hasNext()) {
			iterator.remove();
		}
		 });
	}
}