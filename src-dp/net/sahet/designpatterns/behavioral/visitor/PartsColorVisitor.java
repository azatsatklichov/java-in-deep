package net.sahet.designpatterns.behavioral.visitor;

import java.util.List;

public class PartsColorVisitor implements PartVisitor {

	double colorCost = 0;

	@Override
	public void visit(Door wheel) {
		double cost = 150.00;
		System.out.println("Coloring door costs: " + cost);
		colorCost += cost;
	}

	@Override
	public void visit(Window window) {
		double cost = 120.00;
		System.out.println("Coloring window costs: " + cost);
		colorCost += cost;
	}

	@Override
	public void visit(Table table) {
		double cost = 180.00;
		System.out.println("Coloring table costs: " + cost);
		colorCost += cost;
	}

	@Override
	public void visit(PartsOrder partsOrder) {
		System.out.println("20% discount may apply if you color more than 2 parts");
		List<Part> parts = partsOrder.getParts();
		if (parts.size() > 2) {
			colorCost *= .8;
		}

		System.out.println("Coloring final cost: " + colorCost);
	}
}
