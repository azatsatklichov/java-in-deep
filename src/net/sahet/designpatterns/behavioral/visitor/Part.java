package net.sahet.designpatterns.behavioral.visitor;

public interface Part {

    void accept(PartVisitor visitor);
}
