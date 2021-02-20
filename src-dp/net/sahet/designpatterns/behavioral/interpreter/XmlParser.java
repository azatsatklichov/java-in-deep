package net.sahet.designpatterns.behavioral.interpreter;

public class XmlParser implements Parser {

	private String xmlOutput;

	@Override
	public String parse(String input) {
		// TBD xml parser
		xmlOutput = "<ok>" + input + "</ok>";
		return xmlOutput;
	}
}
