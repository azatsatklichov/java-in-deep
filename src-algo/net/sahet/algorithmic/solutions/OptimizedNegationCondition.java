package package net.sahet.algorithmic.solutions;

import java.util.List;

/**
 * {@inheritDoc}
 * 
 */
public class OptimizedNegationCondition  {

	public static void main(String[] args) {
		List<String> variable = List.of("A", "B");
		List<String> variable2 = List.of("A", "B");

		if (!variable.isEmpty() && !variable2.isEmpty()) {
			System.out.println("optimized algo");
		}

		if (!(variable.isEmpty() || variable2.isEmpty())) {
			System.out.println("commz optimized algo");
		}
	}

}
