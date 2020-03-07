package net.sahet.designpatterns.behavioral.visitor;

public class Table implements Part {

	@Override
	public void accept(PartVisitor visitor) {
		visitor.visit(this);
	}
}
