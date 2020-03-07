package net.sahet.designpatterns.behavioral.interpreter;

public class DefaultParser implements Parser {

	private Parser p1 = null;
	private Parser p2 = null;

	public DefaultParser(Parser p1, Parser p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	@Override
	public String parse(String input) {
		if (p1 != null)
			return p1.parse(input);
		else if (p2 != null)
			return p2.parse(input);

		return "ok = " + input;
	}
}
