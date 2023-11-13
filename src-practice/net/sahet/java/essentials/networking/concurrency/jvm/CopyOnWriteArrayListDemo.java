package net.sahet.java.essentials.networking.concurrency.jvm;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
	/**
	 * CopyOnWriteArrayList API The design of the CopyOnWriteArrayList uses an
	 * interesting technique to make it thread-safe without a need for
	 * synchronization. When we are using any of the modify methods – such as
	 * add() or remove() – the whole content of the CopyOnWriteArrayList is copied
	 * into the new internal copy.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(new Integer[] { 1, 3, 5, 8 });
		System.out.println(numbers);

		List<Integer> result = new LinkedList<>();
		result.iterator().forEachRemaining(result::add);

	}
}
