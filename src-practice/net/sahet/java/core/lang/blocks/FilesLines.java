package net.sahet.java.core.lang.blocks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class FilesLines {
	private final static String filePath = "C:\\workspace-17";

	public static void main(String[] args) {
		// Java 7 Path.of
		// explicitly
		// Path path = Path.of("c:", filePath,
		// "\\src\\main\\java\\features\\in\\java9\\jshell");
		Path path = Path.of(filePath, "/java-in-deep/src-practical/net/sahet/programming/topics/FilesLines.java");

		// Java 8 Files.lines
		try (Stream<String> linesStream = Files.lines(path)) {
			Predicate<String> hasArrow = s -> s.contains("==>");
			Predicate<String> pathOf = s -> !s.contains("Path.of");
			linesStream.dropWhile(Predicate.not(hasArrow)) // .skip(1)
					.takeWhile(pathOf).forEach(System.out::println);
		} catch (IOException e) {
			System.err.println("Err" + e);
		}
	}

}
