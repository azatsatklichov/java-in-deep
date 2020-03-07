package net.sahet.designpatterns.structural.composite;

public class Menu extends BaseMenu {

	public Menu(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public void add(BaseMenu menu) {
		children.add(menu);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(print(this));

		for (BaseMenu menuComponent : children) {
			sb.append(menuComponent.toString());
		}
		return sb.toString();
	}
}
