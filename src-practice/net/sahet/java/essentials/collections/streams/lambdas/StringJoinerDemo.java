package net.sahet.java.essentials.collections.streams.lambdas;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringJoinerDemo {
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(2, 4, 1, 3, 8, 4, 7, 5, 9, 6, 8);
		System.out.println(
				"\nWith Java 8, statistics collectors are introduced to calculate all statistics when stream processing is being done. ");
		IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());

		System.out.println("\n StringJoiner");
		// Join String by a delimiter
		StringJoiner sj = new StringJoiner(",");
		sj.add("aaa");
		sj.add("bbb");
		sj.add("ccc");
		System.out.println(sj); // sj.toString() = aaa,bbb,ccc

		System.out.println("\n String.join ");
		// Join String by a delimiter.
		String result = String.join("-", "2019", "10", "31", "00");
		System.out.println(result); // 2019-10-31-00

		// Join a List by a delimiter.
		List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
		result = String.join(", ", list);
		System.out.println(result); // java, python, nodejs, ruby

		System.out.println("\n Collectors.joining ");
		result = list.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(" | "));
		System.out.println(result); // JAVA | PYTHON | NODEJS | RUBY

		result = list.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", ", "{", "}"));
		System.out.println(result); // JAVA | PYTHON | NODEJS | RUBY
	}

}

class StringAndNumericNewMethods {
	public static void main(String[] args) {
		// String in Java 8
		IntStream is = "ABCDEFG".chars();

		// long count = is.mapToObj(letter ->
		// (char)letter).peek(System.out::print).count();

		is.mapToObj(letter -> (char) letter).peek(System.out::print).forEach(x -> {
			System.out.println("Heyjanelek janelek cakga cakyp bereyin, gurbaganyn ayagyna yupler dakyp bereyin  " + x);
		});

		// Concatenation
		// Before Java 7 this was creating many obsolete objects. With Java 7 internally
		// StringBuilder is used, so nice now
		String s = "A" + "B" + "C";
		System.out.println(s);

		// Then StringBuffer and StringBuilder started to be used
		StringBuilder sb = new StringBuilder();
		sb.append("A").append("B").append("C");
		String str = sb.toString();
		System.out.println(str);
		System.out.println();

		System.out.println("now Java8 way");
		StringJoiner sj = new StringJoiner(", ");
		sj.add("A").add("B").add("C");
		String str2 = sj.toString();
		System.out.println(str2);
		// with delimiter, prefix and postfix, quite handy
		sj = new StringJoiner(", ", "[", "]");
		System.out.println(sj);
		sj.add("A").add("B").add("C");
		sj.add("DD");
		System.out.println(sj);

		System.out.println();
		String join = String.join(":", "A", "B", "C", "D");
		System.out.println(join);

		String[] arr = { "A", "B", "C", "D" };
		join = String.join(":", arr);
		System.out.println(join);

		System.out.println();
		System.out.println("Java 8 news on Numbers");
		System.out.println("Max = " + Long.max(34, -90));
	}
}
