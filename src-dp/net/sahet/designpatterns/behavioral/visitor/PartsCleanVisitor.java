package net.sahet.designpatterns.behavioral.visitor;

public class PartsCleanVisitor implements PartVisitor {

	@Override
	public void visit(Door door) {
		System.out.println("clean door");
	}

	@Override
	public void visit(Window window) {
		System.out.println("clean window");
	}

	@Override
	public void visit(Table table) {
		System.out.println("clean table");
	}

	@Override
	public void visit(PartsOrder partsOrder) {
		System.out.println("clean all");
	}
}
