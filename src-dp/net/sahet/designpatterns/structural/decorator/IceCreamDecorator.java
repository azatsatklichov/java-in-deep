package net.sahet.designpatterns.structural.decorator;

public abstract class IceCreamDecorator implements IceCream {
	
    protected IceCream iceCream;

    public IceCreamDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    public String iceCream() {
        return iceCream.iceCream();
    }
}
