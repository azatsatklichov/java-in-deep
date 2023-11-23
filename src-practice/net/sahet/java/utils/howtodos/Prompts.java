package net.sahet.java.utils.howtodos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Console;
import java.io.IOException;
import java.lang.StackWalker.StackFrame;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Prompts {

	@Test()
	public void whenReadUsing_ReadByConsole_thenCorrect() throws IOException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Console c = System.console();
			String u = c.readLine("%s", "username: ");
			System.out.println("hello " + u);
			String pw; // must be char[]
			// if(c != null && (pw = c.readPassword("%s", "password: ")) != null)
			// check for valid password
			assertEquals("hello", u);
		});

	}

	@Test()
	public void whenReadUsing_WalkOnFiles() {
		// Java 7 Path.of
		Path path = Path.of("c:/..");
		// Java 8 Files.lines
		try (Stream<Path> stream = Files.walk(path)) {
			stream.filter(f -> f.toFile().isDirectory()).forEach(System.out::println);
		} catch (IOException e) {
			System.err.println("Err" + e);
		}

		StackWalker stackWalker = StackWalker.getInstance();
		List<Integer> walk = stackWalker.walk(stackStream -> stackStream.filter(f -> f.getMethodName().startsWith("g"))
				.map(StackFrame::getLineNumber).collect(Collectors.toList()));
		System.out.println(walk);
	}
}
