package net.sahet.java.essentials.collections.streams.lambdas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;
 

//https://www.baeldung.com/java-hashmap
/***
 * One might ask why not simply add the value to a list. Why do we need a
 * HashMap? The simple reason is performance. If we want to find a specific
 * element in a list, the time complexity is O(n) and if the list is sorted, it
 * will be O(log n) using, for example, a binary search.
 * 
 * The advantage of a HashMap is that the time complexity to insert and retrieve
 * a value is O(1) on average. We'll look at how that can be achieved later.
 * Let's first look at how to use HashMap.
 * 
 * 
 * Hashtable and HashMap in Java:
 * 
 * <pre>
 * Hashtable and HashMap are quite similar – both are collections that implement the Map interface.
 * 
 * 1. Firstly, Hashtable is thread-safe and can be shared between multiple threads in the application.
 * We can use Collections.synchronizedMap() to make a thread-safe version of a HashMap. 
 * We can also just create custom lock code or make the code thread-safe by using the synchronized keyword.
 *  
 * HashMap is not synchronized, therefore it's faster and uses less memory than Hashtable. 
 * Generally, unsynchronized objects are faster than synchronized ones in a single threaded application.
 * 
 * 2. Null Values
 * Another difference is null handling. HashMap allows adding one Entry with null as key as well as 
 * many entries with null as value. In contrast, Hashtable doesn't allow null at all.
 * 
 * 
 * 3. Iteration Over Elements
 * HashMap uses Iterator to iterate over values, whereas Hashtable has Enumerator for the same.
 *  The Iterator is a successor of Enumerator that eliminates its few drawbacks. For example, 
 *  Iterator has a remove() method to remove elements from underlying collections.
 *  
 *  The Iterator is a fail-fast iterator. In other words, it throws a 
 *  ConcurrentModificationException when the underlying collection is modified while iterating. 
 * 
 * 
 * 
 * </pre>
 * 
 * 
 */
public class HashMapInJava {

	@Test
	public void whenPutElement_shouldPuElement() {

		Map<String, Product> productsByName = new HashMap<>();
		/*
		 * And add products to our HashMap:
		 */

		Product eBike = new Product("E-Bike", "A bike with a battery");
		Product roadBike = new Product("Road bike", "A bike for competition");
		productsByName.put(eBike.getName(), eBike);
		productsByName.put(roadBike.getName(), roadBike);
		Set<String> hashset = new HashSet<>();

		Product nextPurchase = productsByName.get("E-Bike");
		assertEquals("A bike with a battery", nextPurchase.getDescription());
	}

	/**
	 * HashMap also allows us to have null as a key:
	 * 
	 * and many nulls as value
	 */
	@Test
	public void nullElements() {

		Map<String, Product> productsByName = new HashMap<>();

		Product defaultProduct = new Product("Chocolate", "At least buy chocolate");
		productsByName.put(null, defaultProduct);

		Product nextPurchase = productsByName.get(null);
		assertEquals("At least buy chocolate", nextPurchase.getDescription());

		// Furthermore, we can insert the same object twice with a different key:
		productsByName.put(defaultProduct.getName(), defaultProduct);
		assertSame(productsByName.get(null), productsByName.get("Chocolate"));
	}

	@Test
	public void removeElements() {
		Product eBike = new Product("E-Bike", "A bike with a battery");
		Product roadBike = new Product("Road bike", "A bike for competition");
		Map<String, Product> productsByName = new HashMap<>();
		productsByName.put(eBike.getName(), eBike);
		productsByName.put(roadBike.getName(), roadBike);

		assertTrue(productsByName.containsKey("E-Bike"));
		assertTrue(productsByName.containsValue(eBike));

		// We can remove a key-value mapping from the HashMap:
		productsByName.remove("E-Bike");
		assertNull(productsByName.get("E-Bike"));

	}

	/**
	 * We can use any class as the key in our HashMap. However, for the map to work
	 * properly, we need to provide an implementation for equals() and hashCode().
	 * Let's say we want to have a map with the product as the key and the price as
	 * the value:
	 */
	@Test
	public void cantFindElements() {

		HashMap<Kino, Integer> m = new HashMap<>();

		Kino k1 = new Kino();
		Kino k2 = new Kino();
		m.put(k1, 43);
		m.put(k2, 55);

		assertTrue(m.containsKey(k1));
		// can't find element
		assertFalse(m.containsKey(new Kino()));

		assertTrue(m.containsValue(43));

		System.out.println("we need to provide an implementation for equals() and hashCode()");
		Product eBike = new Product("E-Bike", "A bike with a battery");
		Product roadBike = new Product("Road bike", "A bike for competition");
		Map<String, Product> productsByName = new HashMap<>();
		productsByName.put(eBike.getName(), eBike);
		productsByName.put(roadBike.getName(), roadBike);

		assertTrue(productsByName.containsKey("E-Bike"));
		assertTrue(productsByName.containsValue(eBike));

	}

	@Test
	public void java8getOrDefault_putIfAbsent() {
		System.out.println("we need to provide an implementation for equals() and hashCode()");
		Product eBike = new Product("E-Bike", "A bike with a battery");
		Product roadBike = new Product("Road bike", "A bike for competition");
		Map<String, Product> productsByName = new HashMap<>();
		productsByName.put(eBike.getName(), eBike);
		productsByName.put(roadBike.getName(), roadBike);

		productsByName.forEach((key, product) -> {
			System.out.println("Key: " + key + " Product:" + product.getDescription());
			// do something with the key and value
		});

		System.out.println("getOrDefault()");
		Product chocolate = new Product("chocolate", "something sweet");
		Product defaultProduct = productsByName.getOrDefault("horse carriage", chocolate);
		System.out.println(defaultProduct);
		Product bike = productsByName.getOrDefault("E-Bike", chocolate);
		System.out.println(bike);

		/// before Java8, hey ICM, baya yazipdym ... TERNARY, main usage is provide
		/// DEFAULT-or-alternative value
		Product bike2 = productsByName.containsKey("E-Bike") ? productsByName.get("E-Bike") : chocolate;
		Product defaultProduct2 = productsByName.containsKey("horse carriage") ? productsByName.get("horse carriage")
				: chocolate;

		productsByName.putIfAbsent("E-Bike", chocolate);

		if (productsByName.containsKey("E-Bike")) {
			productsByName.put("E-Bike", chocolate);
		}

	}

	@Test
	public void java8merge_compute() {

		Map<String, Product> productsByName = new HashMap<>();

		Product eBike2 = new Product("E-Bike", "A bike with a battery");
		List<String> tags = Arrays.asList("t1", "t2"); // List.of("t1", "t2"); Unsupported Opt.Ex
		eBike2.setTags(tags);
		eBike2.getTags().add("sport");

		productsByName.merge("E-Bike", eBike2, Product::addTagsOfOtherProdcut);

		productsByName.forEach((key, product) -> {
			System.out.println("Key: " + key + "\n Product:" + product);
		});

		// befor J-8
		if (productsByName.containsKey("E-Bike")) {
			productsByName.get("E-Bike").addTagsOfOtherProdcut(eBike2);
		} else {
			productsByName.put("E-Bike", eBike2);
		}

		productsByName.compute("E-Bike", (k, v) -> {
			if (v != null) {
				return v.addTagsOfOtherProdcut(eBike2);
			} else {
				return eBike2;
			}
		});

		// before J-8
		if (productsByName.containsKey("E-Bike")) {
			productsByName.get("E-Bike").addTagsOfOtherProdcut(eBike2);
		} else {
			productsByName.put("E-Bike", eBike2);
		}

	}

	@Test
	public void whenModifyingHashSetWhileIterating_shouldThrowException() {
		System.out.println("The Iterator throws a ConcurrentModificationException ..");

		/**
		 * The fail-fast behavior of an iterator cannot be guaranteed as it's impossible
		 * to make any hard guarantees in the presence of unsynchronized concurrent
		 * modification.
		 * 
		 * Fail-fast iterators throw ConcurrentModificationException on a best-effort
		 * basis. Therefore, it'd be wrong to write a program that depended on this
		 * exception for its correctness.
		 */
		Assertions.assertThrows(ConcurrentModificationException.class, () -> {

			Set<String> hashset = new HashSet<>();
			hashset.add("First");
			hashset.add("Second");
			hashset.add("Third");
			Iterator<String> itr = hashset.iterator();
			while (itr.hasNext()) {
				itr.next();
				hashset.remove("Second");
			}
		});
	}
 
	class Product {

		private String name;
		private String description;
		private List<String> tags;

		public Product addTagsOfOtherProdcut(Product product) {
			this.tags.addAll(product.getTags());
			return this;
		}

		public Product(String name, String description) {
			this(name, description, null);
		}

		public Product(String name2, String description2, Object object) {
			// TODO Auto-generated constructor stub
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<String> getTags() {
			return tags;
		}

		public void setTags(List<String> tags) {
			this.tags = tags;
		}
		
		
	}

	class Kino {

	}

}
