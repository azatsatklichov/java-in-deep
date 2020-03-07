package net.sahet.designpatterns.structural.bridge;

import java.util.List;

public interface Formatter {

	String format(String header, List<Element> elements);
}
