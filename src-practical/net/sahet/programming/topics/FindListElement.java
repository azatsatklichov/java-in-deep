package net.sahet.programming.topics;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

import lombok.AllArgsConstructor;
import lombok.Data;

//https://www.baeldung.com/find-list-element-java
public class FindListElement {

	@Test
	public void whenTesting_Contains() throws Exception {
		Customer customer1 = new Customer(1, "a");
		Customer customer3 = new Customer(1, "a");
		Customer customer2 = new Customer(2, "a");
		List<Customer> list = Arrays.asList(customer1, customer2, customer3);
		System.out.println(list);
		System.out.println("This is it, List can not find elements if hashCode or equals not properly handled");
		System.out.println(list.indexOf(customer3));
		System.out.println(list.lastIndexOf(customer3));

		String s1 = "Alan";
		String s2 = "Alan";
		List<String> listS = Arrays.asList(s1, "Mulan", s2);
		System.out.println(listS);
		System.out.println(listS.indexOf(s2));
		System.out.println(listS.lastIndexOf(s2));

		s1 = new String("Alan");
		s2 = new String("Alan");
		listS = Arrays.asList(s1, "Mulan", s2);
		System.out.println(listS);
		System.out.println(listS.indexOf(s2));
		System.out.println(listS.lastIndexOf(s2));

	}

	@Test
	public void whenTesting_ContainsOld() throws Exception {
		List<CustomerOld> customers = new ArrayList<>();
		customers.add(new CustomerOld(1, "Jack"));
		customers.add(new CustomerOld(2, "James"));
		CustomerOld c3 = new CustomerOld(3, "Kelly");
		customers.add(c3);
		/**
		 * Note that we've overridden hashCode and equals in our Customer class.
		 * 
		 * Based on our current implementation of equals, two Customer objects with the
		 * same id will be considered equal.
		 * 
		 * As the name suggests, this method returns true if the list contains the
		 * specified element, and returns false otherwise.
		 */
		System.out.println("This is finding,  because of  hashCode or equals handled");
		assertTrue(customers.contains(c3));
		assertTrue(customers.contains(new CustomerOld(3, "Kelly")));
		assertFalse(customers.contains(new CustomerOld(4, "Kelly")));
	}

	@Test
	public void whenTesting_ContainsFail() throws Exception {
		List<CustomerOld2> customers = new ArrayList<>();
		customers.add(new CustomerOld2(1, "Jack"));
		customers.add(new CustomerOld2(2, "James"));
		CustomerOld2 c3 = new CustomerOld2(3, "Kelly");
		customers.add(c3);
		assertTrue(customers.contains(c3));
		System.out.println("This is it, List can not find elements if hashCode or equals not properly handled");
		assertFalse(customers.contains(new CustomerOld2(3, "Kelly")));

		assertFalse(customers.contains(new CustomerOld2(4, "Kelly")));

	}

	@Test
	public void whenTesting_Looping() throws Exception {
		Customer customer1 = new Customer(1, "a");
		Customer customer3 = new Customer(1, "a");
		Customer customer2 = new Customer(2, "a");
		List<Customer> list = List.of(customer1, customer2, customer3);

		Customer foundCustomer = findUsingEnhancedForLoop("a", list);
		assertEquals("a", foundCustomer.getName());

		foundCustomer = findUsingIterator("a", list);
		assertEquals("a", foundCustomer.getName());

		Customer findUsingEnhancedForLoop = findUsingStream("a", list);
		assertEquals("a", findUsingEnhancedForLoop.getName());

	}

	private Customer findUsingEnhancedForLoop(String name, List<Customer> customers) {

		for (Customer customer : customers) {
			if (customer.getName().equals(name)) {
				return customer;
			}
		}
		return null;
	}

	private Customer findUsingIterator(String name, List<Customer> customers) {
		Iterator<Customer> iterator = customers.iterator();
		while (iterator.hasNext()) {
			Customer customer = iterator.next();
			if (customer.getName().equals(name)) {
				return customer;
			}
		}
		return null;
	}

	private Customer findUsingStream(String name, List<Customer> customers) {
		return customers.stream().filter(customer -> name.equals(customer.getName())).findAny().orElse(null);
	}

	@Test
	public void whenFinding_ByGuava() throws Exception {
		Customer customer1 = new Customer(1, "a");
		Customer customer3 = new Customer(1, "a");
		Customer customer2 = new Customer(2, "James");
		List<Customer> list = List.of(customer1, customer2, customer3);

		Customer james = Iterables.tryFind(list, new Predicate<Customer>() {
			public boolean apply(Customer customer) {
				return "James".equals(customer.getName());
			}
		}).orNull();

		assertEquals("James", james.getName());

		// s we can with Stream API, we can optionally choose to return a default value
		// instead of null:
		james = Iterables.tryFind(list, new Predicate<Customer>() {
			public boolean apply(Customer customer) {
				return "Jamess".equals(customer.getName());
			}
		}).or(list.get(0));

		// default case
		assertEquals("a", james.getName());

	}

	@Test
	public void whenFinding_ByApacheCommons() throws Exception {
		Customer customer1 = new Customer(1, "a");
		Customer customer3 = new Customer(1, "a");
		Customer customer2 = new Customer(2, "James");
		List<Customer> list = List.of(customer1, customer2, customer3);

		// IteratorUtils
		Customer find = IterableUtils.find(list, new org.apache.commons.collections4.Predicate<Customer>() {
			public boolean evaluate(Customer customer) {
				return "James".equals(customer.getName());
			}
		});

		assertEquals("James", find.getName());

	}

}

class CustomerOld {

	private int id;
	private String name;

	public CustomerOld(int i, String string) {
		this.id = i;
		this.name = string;
	}

	@Override
	public int hashCode() {
		return id + name.length();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		CustomerOld that = (CustomerOld) obj;
		return id == that.id && name.equals(that.name);
	}
}

class CustomerOld2 {

	private int id;
	private String name;

	public CustomerOld2(int i, String string) {
		this.id = i;
		this.name = string;
	}

}

@AllArgsConstructor
@Data
class Customer {

	private int id;
	private String name;

}