package net.sahet.designpatterns.structural.bridge;

import java.util.List;

public class BannerFormatter implements Formatter {

	@Override
	public String format(String header, List<Element> details) {
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		sb.append("\n");

		for (Element detail : details) {
			sb.append(detail.getLabel()).append(":").append(detail.getValue()).append("\n");
		}

		return sb.toString();
	}
}
