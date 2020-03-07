package net.sahet.designpatterns.behavioral.visitor;

public class VisitorDemo {
	public static void main(String[] args) {
		System.out.println("\n	Visitor design pattern example");

		PartsOrder po = new PartsOrder();
		po.addPart(new Door());
		po.addPart(new Window());
		po.addPart(new Table());

		po.accept(new PartsColorVisitor());
		System.out.println();
		po.accept(new PartsCleanVisitor());

		System.out.println("\n	Visitor Java build-in classes");
		/**
		 * java.lang.model.element.Element
		 * 
		 * java.lang.model.element.ElementVisitor
		 */
	}
}
