package net.sahet.designpatterns.structural.bridge;

import java.util.List;

public class HtmlFormatter implements Formatter {

	@Override
	public String format(String header, List<Element> elements) {
		StringBuilder sb = new StringBuilder();
		sb.append("<h1>");
		sb.append(header);
		sb.append("</h1>");

		sb.append("<ul>");
		for (Element detail : elements) {
			sb.append("<li>").append(detail.getLabel()).append(":").append(detail.getValue()).append("/<li>");
		}
		sb.append("</ul>");

		return sb.toString();
	}
}
