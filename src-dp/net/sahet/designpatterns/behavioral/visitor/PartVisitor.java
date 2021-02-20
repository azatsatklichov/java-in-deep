package net.sahet.designpatterns.behavioral.visitor;

public interface PartVisitor {

	void visit(Door door);

	void visit(Window window);

	void visit(Table table);

	void visit(PartsOrder partsOrder);
}
