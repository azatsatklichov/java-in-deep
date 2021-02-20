package net.sahet.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMenu {

	String name;
	String url;
	List<BaseMenu> children = new ArrayList<>();

	public abstract String toString();

	String print(BaseMenu tree) {
		StringBuilder sb = new StringBuilder(name);
		sb.append(": ");
		sb.append(url);
		sb.append("\n");
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}
}
