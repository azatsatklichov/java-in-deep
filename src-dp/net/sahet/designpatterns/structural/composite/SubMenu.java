package net.sahet.designpatterns.structural.composite;

public class SubMenu extends BaseMenu {

    public SubMenu(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return print(this);
    }
}
