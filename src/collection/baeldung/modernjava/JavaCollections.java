package collection.baeldung.modernjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
 

//https://www.baeldung.com/java-collections
public class JavaCollections {
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

class copyOnWriteArrayListDemo {
	/**
	 * CopyOnWriteArrayList API The design of the CopyOnWriteArrayList uses an
	 * interesting technique to make it thread-safe without a need for
	 * synchronization. When we are using any of the modify methods – such as add()
	 * or remove() – the whole content of the CopyOnWriteArrayList is copied into
	 * the new internal copy.
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