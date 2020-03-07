package net.sahet.designpatterns.behavioral.interpreter;

public class JsonParser implements Parser {

	private String jsonOutput;

	@Override
	public String parse(String input) {
		// TBD json parser
		jsonOutput = "{ok:" + input + "}";
		return jsonOutput;
	}
}
