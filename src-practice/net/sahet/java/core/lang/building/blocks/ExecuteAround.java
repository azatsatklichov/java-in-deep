package net.sahet.java.core.lang.building.blocks;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {
	// private static final String FILE =
	// ExecuteAround.class.getResource("out.txt").getFile();

	public static void main(String... args) throws IOException { 
		String result = processFileLimited();
		System.out.println(result);

		System.out.println("---");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
		System.out.println(twoLines);
	}

	public static String processFileLimited() throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("out.txt"))) {
			return br.readLine();
		}
	}

	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("out.txt"))) {
			return p.process(br);
		}
	}

	public interface BufferedReaderProcessor {

		String process(BufferedReader b) throws IOException;

	}

}
