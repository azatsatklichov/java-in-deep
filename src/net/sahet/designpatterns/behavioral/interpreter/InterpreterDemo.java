package net.sahet.designpatterns.behavioral.interpreter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InterpreterDemo {

	public static void main(String[] args) {
		System.out.println("\n	Interpret design pattern example");
		String input = "interpreter";
		Parser p1 = new XmlParser();
		System.out.println(p1.parse(input));

		Parser p2 = new JsonParser();
		System.out.println(p2.parse(input));

		Parser p3 = new DefaultParser(p1, p2);
		p3 = new DefaultParser(p1, p2);
		System.out.println(p3.parse(input));
		p3 = new DefaultParser(null, null);
		System.out.println(p3.parse(input));
		System.out.println();

		/**
		 * 
		 * 
		 * Expression e1 = new TerminalExpression("Lions"); Expression e2 = new
		 * TerminalExpression("Tigers"); Expression e3 = new
		 * TerminalExpression("Bears"); Expression e4 = new AndExpression(e2, e3);
		 * Expression e5 = new OrExpression(e1, e4);
		 * 
		 * return new AndExpression(e1, e5);
		 * 
		 * 
		 * System.out.println("\n Interpret Java build-in classes "); /**
		 * java.util.Pattern
		 * 
		 * java.text.Format
		 * 
		 */
		String s = "Sen bagtly bolsan elini carp, eger sen bagtly bolsan ayagyny kak, eger sen Bagtly bolson dasyndan aylan .. ";
		Pattern p = Pattern.compile("bagtly | carp");
		Matcher m = p.matcher(s);
		while (m.find()) {
			System.out.println(m.group());
		}

		System.out.println();
		p = Pattern.compile("bagtly|carp|Bagtly");
		m = p.matcher(s);
		while (m.find()) {
			System.out.println(m.group());
		}
	}
}
