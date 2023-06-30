package net.sahet.iviews;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * We're going to start with yet another disclaimer: This small section isn't
 * going to morph you from regex newbie to regex guru. In this section we'll
 * cover three basic ideas:
 * 
 * 
 * <pre>
 * ■  Finding stuff    You've got big heaps of text to look through. Maybe you're 
 * doing some screen scraping, maybe you're reading from a file. In any case, 
 * you need easy ways to find textual needles in textual haystacks. We'll use the 
 * java.util.regex.Pattern, java.util.regex.Matcher, and java.util.Scanner classes 
 * to help us find stuff.
 * 
 * ■  Tokenizing stuff     You've got a delimited file that you want to get useful 
 * data out of. You want to transform a piece of a text file that looks like: 
 * "1500.00,343.77,123.4"  into some individual float variables. We'll show you 
 * the basics of using the String.split() method and the java.util.Scanner 
 * class, to tokenize your data. 
 * 
 * ■  Formatting stuff    You've got a report to create and you need to take a float 
 * variable with a value of 32500.000f and transform it into a String with a 
 * value of "$32,500.00". We'll introduce you to the java.util.Formatter class 
 * and to the printf() and format() methods.
 *  
 * 
 * A Search Tutorial
 * 
 * Whether you're looking for stuff or tokenizing stuff, a lot of the concepts are the 
 * same, so let's start with some basics. No matter what language you're using, sooner 
 * or later you'll probably be faced with the need to search through large amounts of 
 * textual data, looking for some specific stuff. 
 * 
 * 
 * Regular expressions (regex for short) are a kind of language within a language, 
 * designed to help programmers with these searching tasks. Every language that 
 * provides regex capabilities uses one or more regex engines. Regex engines search 
 * through textual data using instructions that are coded into expressions. A regex 
 * expression is like a very short program or script. When you invoke a regex engine, 
 * you'll pass it the chunk of textual data you want it to process (in Java this is usually 
 * a String or a stream), and you pass it the expression you want it to use to search 
 * through the data. 
 * 
 * It's fair to think of regex as a language, and we will refer to it that way throughout 
 * this section. The regex language is used to create expressions, and as we work 
 * through this section, whenever we talk about expressions or expression syntax, we're 
 * talking about syntax for the regex "language."  Oh, one more disclaimer…we know 
 * that you regex mavens out there can come up with better expressions than what
 * </pre>
 * 
 */
public class P_RegEx_ParsingTokenizingAndFormatting_Scanner {

}

/**
 * <pre>
 * Tokenizing
 * 
 * 
 * Tokenizing is the process of taking big pieces of source data, breaking them
 * into little pieces, and storing the little pieces in variables.
 * 
 * Probably the most common tokenizing situation is reading a delimited file in
 * order to get the contents of the file
 * 
 * 
 * Tokens and Delimiters
 * 
 * 
 * When we talk about tokenizing, we're talking about data that starts out
 * composed of two things: tokens and delimiters. Tokens are the actual pieces
 * of data, and delimit- ers are the expressions that separate the tokens from
 * each other. When most people think of delimiters, they think of single
 * characters, like commas or backslashes or maybe a single whitespace.
 * 
 * These are indeed very common delimiters, but strictly speaking, delimiters
 * can be much more dynamic. In fact, as we hinted at a few sen- tences ago,
 * delimiters can be anything that qualifies as a regex expression. Let's take a
 * single piece of source data and tokenize it using a couple of different
 * delimiters:
 * 
 * 
 * source: "ab,cd5b,6x,z4"
 * 
 * If we say that our delimiter is a comma, then our four tokens would be
 * 
 * ab cd5b 6x z4
 * 
 * If we say that our delimiter is a comma, then our four tokens would be
 *  
 * ab
 * cd5b
 * 6x
 * z4
 * 
 * If we use the same source, but declare our 
 * delimiter to be \d, we get three tokens:
 * 
 * ab,cd
 * b,
 * x,z
 * 
 * 
 * </pre>
 * 
 */
class Tokenizing {

	// % java SplitTest "ab5 ccc 45 @" "\d"
	public static void main(String[] args) {
		/**
		 * (Note: Remember that to represent "\" in a string you may need to use
		 * the escape sequence "\\". Because of this, and depending on your OS,
		 * your second argument might have to be "\\d" or even "\\\\d".)
		 */
		String[] tokens = "ab5 ccc 45 @".split("\\d");// args[0].split(args[1]);
		System.out.println("count " + tokens.length);
		for (String s : tokens)
			System.out.println(">" + s + "<");

		System.out.println();
		/*
		 * So, what if you need to search for periods (.) in your source data?
		 * If you just put a period in the regex expression, you get the
		 * "any character" behavior. So, what if you try \. ? Now the Java
		 * compiler thinks you're trying to create an escape sequence that
		 * doesn’t exist. The correct syntax is
		 */

		String s = "ab.cde.fg";
		tokens = s.split("\\.");
		for (String string : tokens) {
			System.out.println(string);
		}
	}

}

/**
 * Tokenizing with Scanner The java.util.Scanner class is the Cadillac of
 * tokenizing. When you need to do som serious tokenizing, look no further than
 * Scanner—this beauty has it all. In addition to the basic tokenizing
 * capabilities provided by String.split(), the Scanner clas offers the
 * following features:
 * 
 * ■ Scanners can be constructed using files, streams, or Strings as a source.
 * 
 * ■ Tokenizing is performed within a loop so that you can exit the process at
 * any point.
 * 
 * ■ Tokens can be converted to their appropriate primitive types automatically.
 * Let's look at a program that demonstrates several of Scanner's methods and
 * capabilities. Scanner's default delimiter is whitespace, which this program
 * uses.
 * 
 * 
 * The program makes two Scanner objects: s1 is iterated over with the more
 * generic next() method, which returns every token as a String, while s2 is
 * analyzed with several of the specialized nextXxx() methods (where Xxx is a
 * primitive type):
 * 
 * 
 * 
 */
class Tokenizing_With_Scanner {

	// % java ScanNext "1 true 34 hi"
	public static void main(String[] args) {
		boolean b2, b;
		int i;
		String s, hits = " ";
		String source = "1";// args[0];
		Scanner s1 = new Scanner(source);
		Scanner s2 = new Scanner(source);
		while (b = s1.hasNext()) {
			s = s1.next();
			hits += "s";
		}
		while (b = s2.hasNext()) {
			if (s2.hasNextInt()) {
				i = s2.nextInt();
				hits += "i";
			} else if (s2.hasNextBoolean()) {
				b2 = s2.nextBoolean();
				hits += "b";
			} else {
				s2.next();
				hits += "s2";
			}
		}
		System.out.println("hits " + hits);
	}
}

/**
 * 
 * <p>
 * Desc:
 * </p>
 * 
 * <pre>
 *  Let's look at what just happened. Inside the double quotes there is a format string, 
 * then a +, and then a second format string. Notice that we mixed literals in with 
 * the format strings. Now let's dive in a little deeper and look at the construction of 
 * format strings:
 * 
 * %[arg_index$][flags][width][.precision]conversion char
 * 
 * 
 * The values within [ ] are optional. In other words, the only required elements of 
 * a format string are the % and a conversion character. In the example above the only 
 * optional values we used were for argument indexing. 
 * The 2$ represents the second 
 * argument, and the 1$ represents the first argument. (Notice that there's no problem 
 * switching the order of arguments.) The d after the arguments is a conversion 
 * character (more or less the type of the argument). Here's a rundown of the format 
 * string elements you'll need to know for the exam:
 * 
 * 
 * arg_index An integer followed directly by a $, this indicates which argument 
 * should be printed in this position.
 * 
 * 
 * flags While many flags are available, for the exam you'll need to know:
 * 
 * ■ "-" Left justify this argument
 * 
 * ■ "+" Include a sign (+ or -) with this argument
 * 
 * ■ "0" Pad this argument with zeroes
 * 
 * ■ "," Use locale-specific grouping separators (i.e., the comma in 123,456)
 * 
 * ■ "(" Enclose negative numbers in parenthesess
 * 
 * 
 * width  - This value indicates the minimum number of characters to print. (If you 
 * want nice even columns, you'll use this value extensively.)
 * 
 * 
 * precision  - For the exam you'll only need this when formatting a floating-point 
 * number, and in the case of floating point numbers, precision indicates the number of 
 * digits to print after the decimal point.
 * 
 * conversion The type of argument you'll be formatting. You'll need to know:
 * 
 * ■  b boolean
 * 
 * ■  c char
 * 
 * ■  d integer
 * 
 * ■  f floating point
 * 
 * ■  s string
 * </pre>
 * 
 * 
 */
class Formatting {

	public static void main(String[] args) {
		int i1 = -123;
		int i2 = 12345;
		System.out.printf(">%1$(7d< \n", i1);
		System.out.printf(">%0,7d< \n", i2);
		System.out.format(">%+-7d< \n", i2);
		System.out.printf(">%2$b + %1$5d< \n", i1, false);

		/*
		 * Exception in thread "main" java.util.IllegalFormatConversionEx-
		 * ception: d != java.lang.Double
		 */
		System.out.format("%d", 12.3);
	}

}

/**
 * In all of these discussions we'll assume that our data sources use zero-based
 * indexes, so if we apply an index to our source string we get
 * 
 * <pre>
 * source: abaaaba
 * index:  0123456
 * 
 * 
 * 
 * If we change the previous program to apply the expression \d to the following 
 * source string
 * 
 * source: a12c3e456f
 * index:  0123456789
 * 
 * regex will tell us that it found digits at positions 1, 2, 4, 6, 7, and 8. (If you want to 
 * try this at home, you'll need to "escape" the compile method's "\d" argument by 
 * making it "\\d", more on this a little later.)
 * 
 * Regex provides a rich set of metacharacters that you can find described in the 
 * API documentation for java.util.regex.Pattern. We won't discuss them all here, but 
 * we will describe the ones you'll need for the exam:
 * 
 * \d A digit
 * \s A whitespace character
 * \w A word character (letters, digits, or "_" (underscore))
 * 
 * So for example, given
 * 
 * source: "a 1 56 _Z"
 * index:   012345678
 * pattern: \w
 * 
 * regex will return positions 0, 2, 4, 5, 7, and 8. The only characters in this source that 
 * don't match the definition of a word character are the whitespaces. (Note: In this 
 * example we enclosed the source data in quotes to clearly indicate that there was no 
 * whitespace at either end.) 
 * 
 * You can also specify sets of characters to search for using square brackets and 
 * ranges of characters to search for using square brackets and a dash:
 * 
 * [abc]    Searches only for a's, b's or c's
 * [a-f]    Searches only for a, b, c, d, e, or f characters
 * 
 * In addition, you can search across several ranges at once. The following 
 * expression is looking for occurrences of the letters a - f or A - F, it's NOT looking 
 * for an fA combination:
 * 
 * 
 * [a-fA-F]    Searches for the first six letters of the alphabet, both cases.
 * 
 * 
 * So for instance,
 * 
 * source: "cafeBABE"
 * index:   01234567
 * pattern: [a-cA-C]
 * 
 * returns positions 0, 1, 4, 5, 6.
 * </pre>
 * 
 * 
 * <p>
 * Searches Using Quantifiers
 * </p>
 * 
 * <pre>
 * Let's say that we want to create a regex pattern to search for hexadecimal literals. As 
 * a first step, let's solve the problem for one-digit hexadecimal numbers:
 * 
 * 0[xX][0-9a-fA-F]
 * 
 * The preceding expression could be stated: "Find a set of characters in which the 
 * first character is a "0", the second character is either an "x" or an "X", and the third 
 * character is either a digit from "0" to "9", a letter from "a" to "f" or an uppercase 
 * letter from "A" to "F" ". Using the preceding expression, and the following data,
 * 
 * source: "12 0x 0x12 0Xf 0xg"
 * index:   012345678901234567
 * 
 * regex would return 6 and 11. (Note:  0x and 0xg are not valid hex numbers.)
 * </pre>
 * 
 * 
 */
class RegexSmall {
	public static void main(String[] args) {
		Pattern p = Pattern.compile("ab"); // the expression
		Matcher m = p.matcher("abaaaba"); // the source
		while (m.find()) {
			System.out.print(m.start() + " ");
		}

		/**
		 * 
		 * <p>
		 * Desc:
		 * </p>
		 * 
		 * <pre>
		 *  more sense. Here's a more complicated example of a source and an expression:
		 * source: abababa
		 * index:  0123456
		 * expression: aba
		 * </pre>
		 */
		System.out.println();
		p = Pattern.compile("aba"); // the expression
		m = p.matcher("abaaaba"); // the source
		while (m.find()) {
			System.out.print(m.start() + " ");
		}

		System.out.println("\n    search HEX ");
		/**
		 * source:
		 * 
		 * index: 012345678901234567
		 * 
		 * regex would return 6 and 11. (Note: 0x and 0xg are not valid hex
		 * numbers.)
		 * 
		 */
		p = Pattern.compile("0[xX][0-9a-fA-F]"); // the expression
		m = p.matcher("12 0x 0x12 0Xf 0xg"); // the source
		while (m.find()) {
			System.out.print(m.start() + " ");
		}

		System.out.println();
		p = Pattern.compile("0[xX]([0-9a-fA-F])+"); // the expression
		m = p.matcher("12 0x 0x12 0Xf 0xg"); // the source
		while (m.find()) {
			System.out.print(m.start() + " ");
		}

		/**
		 * 
		 * <pre>
		 * The other issue this raises is that when we're searching for something whose 
		 * length is variable, getting only a starting position as a return value has limited value. 
		 * So, in addition to returning starting positions, another bit of information that a 
		 * regex engine can return is the entire match or group that it finds. We're going to 
		 * change the way we talk about what regex returns by specifying each return on its 
		 * own line, remembering that now for each return we're going to get back the starting 
		 * position AND then the group:
		 * 
		 * source: "1 a12 234b"
		 * 
		 * pattern: \d+
		 * 
		 *  For  instance, if you want to find anything but a's, b's, or c's in a file you could say
		 * [^abc]
		 * 
		 * </pre>
		 */
		System.out.println();
		p = Pattern.compile("\\d+"); // the expression
		m = p.matcher("1 a12 234b"); // the source
		while (m.find()) {
			System.out.print(m.start() + " ");
		}

		System.out.println();
		p = Pattern.compile("proj1([^,])*"); // the expression
		m = p.matcher("proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java"); // the
																			// source
		while (m.find()) {
			System.out.println(m.start() + ": " + m.group());
		}

		/*
		 * The key to creating this expression is to see that we need "zero or
		 * one instance of either a space or a dash" in the middle of our
		 * digits:
		 * 
		 * \d\d\d([-\s])?\d\d\d\d
		 * 
		 * 1234567
		 * 
		 * 123 4567
		 * 
		 * 123-4567
		 */
		System.out.println();
		p = Pattern.compile("\\d\\d\\d([-\\s])?\\d\\d\\d\\d"); // the expression
		m = p.matcher("123-4567 des8fs 123 4567 zd-sf  1234567"); // the
																	// source
		while (m.find()) {
			System.out.println(m.start() + ": " + m.group());
		}

		/**
		 * 
		 * <p>
		 * The Predefined Dot
		 * </p>
		 * 
		 * <pre>
		 *  In addition to the \s, \d, and \w metacharacters that we discussed, you also have 
		 * to understand the "." (dot) metacharacter. When you see this character in a regex 
		 * expression, it means "any character can serve here." For instance, the following 
		 * source and pattern
		 * 
		 * source: "ac abc a c"
		 * pattern: a.c
		 * 
		 * will produce the output
		 * 
		 * 3 abc
		 * 7 a c
		 * 
		 * 
		 * The "." was able to match both the "b" and the "  " in the source data.
		 * 
		 *  "." (dot) --> "any character can serve here."
		 * </pre>
		 * 
		 * 
		 */
		System.out.println();
		p = Pattern.compile("a.c"); // the expression
		m = p.matcher("ac abc a c"); // the
										// source
		while (m.find()) {
			System.out.println(m.start() + ": " + m.group());
		}

	}
}

/**
 * Greedy Quantifiers
 * 
 * <pre>
 * 
 * When you use the *, +, and ? quantifiers, 
 * you can fine tune them a bit to produce 
 * behavior that's known as "greedy", "reluctant", 
 * or "possessive". Although you need 
 * to understand only the greedy quantifier for the exam, 
 * we're also going to discuss the 
 * reluctant quantifier to serve as a basis for comparison. 
 * First the syntax:
 * 
 * ? is greedy, ?? is reluctant, for zero or once
 * 
 * is greedy, *? is reluctant, for zero or more
 * 
 * + is greedy, +? is reluctant, for one or more
 * </pre>
 * 
 */
class GreedyQuantifiers {

	public static void main(String[] args) {
		/*
		 * When Metacharacters and Strings Collide
		 * 
		 * 
		 * So far we've been talking about regex from a theoretical perspective.
		 * Before we can put regex to work we have to discuss one more gotcha.
		 * When it's time to implement regex in our code, it will be quite
		 * common that our source data and/or our expressions will be stored in
		 * Strings. The problem is that metacharacters and Strings don't mix too
		 * well. For instance. let's say we just want to do a simple regex
		 * pattern that looks for digits. We might try something like
		 */

		// pattern = "\d"; // compiler error!

		/*
		 * This line of code won't compile!
		 * 
		 * The compiler sees the \ and thinks, "Ok, here comes an escape
		 * sequence, maybe it'll be a new line!" But no, next comes the d and
		 * the compiler says "I've never heard of the \d escape sequence." The
		 * way to satisfy the compiler is to add another backslash in front of
		 * the \d
		 */

		String pattern = "\\d"; // a compilable metacharacter

		/*
		 * The first backslash tells the compiler that whatever comes next
		 * should be taken literally, not as an escape sequence. How about the
		 * dot (.) metacharacter? If we want a dot in our expression to be used
		 * as a metacharacter, then no problem, but what if we're reading some
		 * source data that happens to use dots as delimiters? Here's another
		 * way to look at our options:
		 */

		String p = "."; // regex sees this as the "." metacharacter
		// String p2 = "\." // the compiler sees this as an illegal
		// Java escape sequence

		p = "\\."; // the compiler is happy, and regex sees a
		// dot, not a metacharacter

	}
}

/**
 * Locating Data via Pattern Matching
 * 
 * <pre>
 * 
 * Once you know a little regex, using the java.util.regex.Pattern (Pattern) and 
 * java.util.regex.Matcher (Matcher) classes is pretty straightforward. The Pattern 
 * class is used to hold a representation of a regex expression, so that it can be used 
 * and reused by instances of the Matcher class. 
 * 
 * The Matcher class is used to invoke 
 * the regex engine with the intention of performing match operations. The following 
 * program shows Pattern and Matcher in action, and it's not a bad way for you to do 
 * your own regex experiments.
 * 
 *  Note, you might want to modify the following class by 
 * adding some functionality from the Console class. That way you'll get some practice 
 * with the Console class, and it'll be easier to run multiple regex experiments.
 * </pre>
 * 
 */
class LocatingDataViaPatternMatching {

}
