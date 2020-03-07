package net.sahet.designpatterns.behavioral.visitor;

public class Window implements Part {

    @Override
    public void accept(PartVisitor visitor) {
        visitor.visit(this);
    }
}
