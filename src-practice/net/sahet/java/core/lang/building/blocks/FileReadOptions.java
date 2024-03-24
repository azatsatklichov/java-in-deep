package net.sahet.java.core.lang.building.blocks;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.Writer;
import java.lang.StackWalker.StackFrame;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * References
 * 
 * https://www.baeldung.com/java-read-file
 * https://www.baeldung.com/reading-file-in-java
 * 
 * https://www.geeksforgeeks.org/ways-to-read-input-from-console-in-java/
 * https://jenkov.com/tutorials/java-io/files.html
 * 
 * * i.a. either Solution Architect or Principal Software Engineer elh.skr
 *
 */

public class FileReadOptions {

	public static final String EXPECTED_DATA = "palin duzuw bolsyn\n";
	public static final String EXPECTED_DATA2 = "palin duzuw bolsyn";

	public static final String file = "src-practice/fileinclasspath2.txt";
	public static final String binFile = "src-practice/emp.ser";
	private String dirPath = "C:\\\\workspace-17\\\\java-in-deep\\\\src-practice";

	private String readFromInputStream(InputStream inputStream) throws IOException {
		StringBuilder resultStringBuilder = new StringBuilder();
		// InputStreamReader - is used as wrapper[adapter] between byte-to-char
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}
		return resultStringBuilder.toString();
	}

	/**
	 * Reading a File from the Classpath - Using Standard Java
	 */
	@Test
	public void whenReadUsing_Classpath_thenFileData() {

		/**
		 * /** You will get NPE here if file is not in this package. when using
		 * getResourceAsStream method absolute path of the file is put to load file at
		 * runtime
		 */
		try (InputStream inputStream = FileReadOptions.class.getResourceAsStream("fileinclasspath.txt")) {
			String data = readFromInputStream(inputStream);
			assertEquals(EXPECTED_DATA, data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Reading a File from the Classpath - Using Standard Java
	 * 
	 * The same method is available on a ClassLoader instance as well:
	 * 
	 * The main difference is that when using the getResourceAsStream on a
	 * ClassLoader instance, the path is treated as absolute starting from the root
	 * of the classpath.
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_Classpath_thenFileData2() throws IOException {
		/**
		 * You will get NPE here if file is not on ROOT.
		 * 
		 * When used against a Class instance, the path could be relative to the
		 * package, or an absolute path, which is hinted by the leading slash.
		 */
		ClassLoader classLoader = getClass().getClassLoader();// NPE
		// ClassLoader classLoader = FileReadOptions.class.getClassLoader();
		try (InputStream inputStream = classLoader.getResourceAsStream("fileinclasspath2.txt")) {
			String data = readFromInputStream(inputStream);
			assertEquals(EXPECTED_DATA, data);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Reading a File from the Classpath - Using the commons-io Library via
	 * FileUtils
	 */
	@Test
	public void whenReadUsing_CommonsIO_FileUtils_thenFileData() throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("fileinclasspath2.txt").getFile());
		String data = FileUtils.readFileToString(file, "UTF-8");
		assertEquals(EXPECTED_DATA2, data);
	}

	/**
	 * Reading a File from the Classpath - Using the commons-io Library - via
	 * IOUtils class:
	 */
	@Test
	public void whenReadUsing_CommonsIO_IOUtils_thenFileData() throws IOException {
		FileInputStream fis = new FileInputStream("src-practice/fileinclasspath2.txt");
		String data = IOUtils.toString(fis, "UTF-8");
		assertEquals(EXPECTED_DATA2, data);
	}

	/**
	 * Reading with BufferedReader
	 * 
	 * Note that readLine() will return null when the end of the file is reached.
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_BufferedReader_thenCorrect() throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(file));
		String currentLine = reader.readLine();
		reader.close();

		assertEquals(EXPECTED_DATA2, currentLine);
	}

	/**
	 * Reading from a File Using Java NIO.
	 * 
	 * Reading SMALL file
	 * 
	 * In JDK7, the NIO package was significantly updated. Let’s look at an example
	 * using the Files class and the readAllLines method. The readAllLines method
	 * accepts a Path.
	 * 
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_JavaNIO_smallFile_thenCorrect() throws IOException {

		Path path = Paths.get(file);

		// we can use the readAllBytes() method also to read binary data as below.
		// Java 7 way
		String currentLine = Files.readAllLines(path).get(0);

		assertEquals(EXPECTED_DATA2, currentLine);
	}

	/**
	 * Reading a File Using Files.lines()
	 * 
	 * JDK8 offers the lines() method inside the Files class. It returns a Stream of
	 * String elements.
	 * 
	 * Let’s look at an example of how to read data into bytes and decode it using
	 * UTF-8 charset.
	 * 
	 * The following code reads the file using the new Files.lines():
	 * 
	 * 
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	@Test
	public void whenReadUsing_Fileslines_thenCorrect() throws IOException, URISyntaxException {

		Path path = Paths.get(getClass().getClassLoader().getResource("fileinclasspath2.txt").toURI());
		Stream<String> lines = Files.lines(path);
		String data = lines.collect(Collectors.joining("\n"));
		/*
		 * Using Stream with IO channels like file operations, we need to close the
		 * stream explicitly using the close() method.
		 */
		lines.close();

		assertEquals(EXPECTED_DATA2, data);
	}
	
	/**
	 * 
	 * Reading Files via Java 11
	 * 
	 * or
	 * 
	 * If you need to read a file from one end to the other you can use a
	 * FileInputStream or a FileReader depending on whether you want to read the
	 * file as binary or textual data.
	 * 
	 * If you need to jump around the file and read only parts of it from here and
	 * there, you can use a RandomAccessFile.
	 * 
	 * 
	 * Writing File via Java 11
	 * 
	 * or
	 * 
	 * If you need to write a file from one end to the other you can use a
	 * FileOutputStream or a FileWriter depending on whether you need to write
	 * binary data or characters. If you need to skip around a file and write to it
	 * in various places, for instance appending to the end of the file, you can use
	 * a RandomAccessFile.
	 * 
	 * @throws IOException
	 * 
	 * 
	 */
	@Test
	public void whenReadUsing_FilesreadString_thenCorrect() throws IOException {

		//Path path = Path.of("C:\\workspace-17\\java-in-deep\\src-practice\\net\\sahet\\java\\core\\lang\\blocks");
		var data = Files.readString(Path.of("words.txt"));		
		System.out.println(data);
		Files.writeString(Path.of("words_fazilSay.txt"), data); 
	}

	/**
	 * MGM aydypdy SMALL file diyip
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_smallFile_thenCorrect_MGM() throws IOException {
		Path path = Paths.get(file);

		List<Mgm> list = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			stream.forEach(line -> {
				assertEquals(EXPECTED_DATA2, line);
				// addMgm(list, line);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}

		// assertEquals(1, list.size());
	}

	@Test
	public void whenReadUsing_JavaNIO_smallBinaryFile_thenCorrect() throws IOException {
		Path path = Paths.get(binFile);
		byte[] readAllBytes = Files.readAllBytes(path);

		String data = new String(readAllBytes);
		assertTrue(data.contains("designpatterns.behavioral"));

		// helps to get rid-off ICM PDF like issues
		data = new String(readAllBytes, StandardCharsets.UTF_8);
		System.out.println(data);

		// or
		System.out.println("String to byte array: " + Arrays.toString(readAllBytes));

		byte[] byteArr = "test-files".getBytes(StandardCharsets.UTF_8);
		System.out.println(Arrays.toString(byteArr));
		System.out.println(new String(byteArr));
		byte[] byteArray1 = { 80, 65, 78, 75, 65, 74 };// pankaj
		String str = new String(byteArray1, 0, 3, StandardCharsets.UTF_8);
		System.out.println(str);
		str = new String(byteArray1, StandardCharsets.UTF_8);
		System.out.println(str);
	}

	/**
	 * Reading from a File Using Java NIO.
	 * 
	 * For reading BIG File - we can use the newBufferedReader() on BufferedReader
	 * 
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_JavaNIO_bigFile_thenCorrect() throws IOException {

		Path path = Paths.get(file);
		BufferedReader reader = Files.newBufferedReader(path);
		String line = reader.readLine();
		assertEquals(EXPECTED_DATA2, line);
	}

	/**
	 * MGM and HPE uchin gereklidi
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_JavaNIO_bigFile_thenCorrect2() throws IOException {
		Path path = Paths.get(file);
		// String line = reader.readLine();
		int count = 0;
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		assertEquals(1, count);
	}

	@Test
	public void whenReadUsing_BigFile_MGM() throws IOException {
		List<Mgm> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				// try on different file
				// addMgm(list, line);
				assertEquals(EXPECTED_DATA2, line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addMgm(List<Mgm> list, String line) {
		System.out.println(line);
		String[] split = line.toString().split(";");
		Mgm mgm = new Mgm(split[0], new Integer(split[1]));
		list.add(mgm);
	}

	/**
	 * Reading with Scanner - Note that the default delimiter is the whitespace, but
	 * multiple delimiters can be used with a Scanner.
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_Scanner_thenCorrect() throws IOException {
		Scanner scanner = new Scanner(new File(file));
		/**
		 * Note that the default delimiter is the whitespace, but multiple delimiters
		 * can be used with a Scanner.
		 */
		// scanner.useDelimiter(" "); //implicitly

		assertTrue(scanner.hasNext());
		assertEquals("palin", scanner.next());
		assertEquals("duzuw", scanner.next());
		assertEquals("bolsyn", scanner.next());
		// assertEquals(1, scanner.nextInt());

		scanner.close();
	}

	@Test
	public void whenReadUsing_Scanner_thenCorrect_MGM() throws IOException {
		List<Mgm> list = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File(file))) {
			while (scanner.hasNext()) {
				assertTrue((scanner.hasNext()));
				assertEquals("palin", scanner.next());
				String line = scanner.nextLine();
				assertEquals(" duzuw bolsyn", line);
				// addMgm(list, line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// assertEquals(4, list.size());
	}

	/**
	 * Reading with StreamTokenizer - This approach is useful for parsing an input
	 * stream into tokens.
	 * 
	 * 
	 * The tokenizer works by first figuring out what the next token is, String or
	 * number. We do that by looking at the tokenizer.ttype field.
	 * 
	 * Then we’ll read the actual token based on this type:
	 * 
	 * <pre>
		tokenizer.nval – if the type was a number
		tokenizer.sval – if the type was a String
	 * </pre>
	 * 
	 * 
	 * @throws IOException
	 */

	@Test
	public void whenReadUsing_StreamTokenizer_thenCorrectTokens() throws IOException {
		FileReader reader = new FileReader(file);
		StreamTokenizer tokenizer = new StreamTokenizer(reader);

		// token 1
		tokenizer.nextToken();
		assertEquals(StreamTokenizer.TT_WORD, tokenizer.ttype);
		assertEquals("palin", tokenizer.sval);

		// token 2
		tokenizer.nextToken();
		assertEquals(StreamTokenizer.TT_WORD, tokenizer.ttype);
		assertEquals("duzuw", tokenizer.sval);

		// token 3
		tokenizer.nextToken();
		assertEquals(StreamTokenizer.TT_WORD, tokenizer.ttype);
		assertEquals("bolsyn", tokenizer.sval);

		// token 4
		tokenizer.nextToken();
		assertEquals(StreamTokenizer.TT_EOF, tokenizer.ttype);
		assertEquals(null, tokenizer.sval);

		// token 5
		// tokenizer.nextToken();
		// assertEquals(StreamTokenizer.TT_NUMBER, tokenizer.ttype);
		// assertEquals(1, tokenizer.nval, 0.0000001);

		// token 6
		// tokenizer.nextToken();
		// assertEquals(StreamTokenizer.TT_EOF, tokenizer.ttype);

		reader.close();
	}

	/**
	 * Reading with DataInputStream
	 * 
	 * We can use DataInputStream to read binary or primitive data types from a
	 * file.
	 * 
	 * 
	 * Java DataInputStream class allows an application to read primitive data from
	 * the input stream in a machine-independent way.
	 * 
	 * The DataInputStream is handy if the data you need to read consists of Java
	 * primitives larger than one byte each, like int, long, float, double etc. The
	 * DataInputStream expects the multi byte primitives to be written in network
	 * byte order (Big Endian - most significant byte first).
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_DataInputStream_thenCorrect() throws IOException {
		DataInputStream reader = new DataInputStream(new FileInputStream(file));
		int nBytesToRead = reader.available();
		// String result = reader.readUTF(); //EOF exception
		String result = null;
		if (nBytesToRead > 0) {
			byte[] bytes = new byte[nBytesToRead];
			reader.read(bytes);
			result = new String(bytes);
		}

		reader.close();

		assertEquals(EXPECTED_DATA2, result);
	}

	/**
	 * Reading with FileChannel
	 * 
	 * If we are reading a large file, FileChannel can be faster than standard IO.
	 * 
	 * The following code reads data bytes from the file using FileChannel and
	 * RandomAccessFile:
	 * 
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_NIO_FileChannel_thenCorrect() throws IOException {
		RandomAccessFile reader = new RandomAccessFile(file, "r");
		FileChannel channel = reader.getChannel();

		int bufferSize = 1024;
		if (bufferSize > channel.size()) {
			bufferSize = (int) channel.size();
		}
		ByteBuffer buff = ByteBuffer.allocate(bufferSize);
		channel.read(buff);
		buff.flip();

		assertEquals(EXPECTED_DATA2, new String(buff.array()));
		channel.close();
		reader.close();
	}

	/**
	 * If we want to read the int stored at specific location, we can use the
	 * following method:
	 * 
	 * 
	 * @param filename
	 * @param position
	 * @return
	 * @throws IOException
	 */
	private int readFromPosition(String filename, long position) throws IOException {
		int result = 0;
		RandomAccessFile reader = new RandomAccessFile(filename, "r");
		reader.seek(position);
		result = reader.readInt();
		reader.close();
		return result;
	}

	/**
	 * Reading a UTF-8 Encoded File
	 * 
	 * Now let’s see how to read a UTF-8 encoded file using BufferedReader. In this
	 * example, we’ll read a file that contains Chinese characters:
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_UTF8EncodedFile_thenCorrect() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String currentLine = reader.readLine();
		reader.close();

		assertEquals(EXPECTED_DATA2, currentLine);
	}

	/**
	 * Reading Content from URLConnection
	 * 
	 * 
	 * To read content from a URL, we will use “/” URL in our example:
	 * 
	 * There are also alternative ways of connecting to a URL. Here we used the URL
	 * and URLConnection class available in the standard SDK.
	 * 
	 * @throws IOException
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_URLConnection_thenCorrect() throws IOException {

		URL sahet = new URL("http://sahet.net/");
		URLConnection yc = sahet.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
		String inputLine;
		boolean containsMisgin = false;
		while ((inputLine = in.readLine()) != null) {
			System.out.println("----->" + inputLine);
			if (inputLine.contains("sahet")) {
				containsMisgin = true;
				break;
			}
		}
		in.close();

		assertTrue(containsMisgin);
	}

	@Test()
	public void whenReadUsing_URLConnection_thenCorrect2() throws IOException {
		String file3 = "file:///C:\\__che4z-project\\___Technical Session\\Interskills\\z-All Training\\Refs\\unix_tutorial.pdf";

		URL url = new URL(file3);// http://sahet.net/src/downloads/presentation.pdf
		URLConnection urlConnection = url.openConnection();
		InputStream input = urlConnection.getInputStream();
		int data = input.read();
		while (data != -1) {
			System.out.print((char) data);
			data = input.read();
		}
		input.close();
	}

	/**
	 * Reading Content from URL Reader
	 * 
	 * 
	 * To read content from a URL, we will use “/” URL in our example:
	 * 
	 * There are also alternative ways of connecting to a URL. Here we used the URL
	 * and URLConnection class available in the standard SDK.
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_URLReader_thenCorrect() throws IOException {
		URL sahet = new URL("http://sahet.net/");
		BufferedReader in = new BufferedReader(new InputStreamReader(sahet.openStream()));
		boolean containsMisgin = false;

		String inputLine;
		while ((inputLine = in.readLine()) != null)
			if (inputLine.contains("Azat") || inputLine.contains("Misgin")
					|| !(inputLine.contains("href") || inputLine.contains("<p"))) {
				System.out.println(inputLine);
				containsMisgin = true;
				break;
			}

		in.close();
		assertTrue(containsMisgin);
	}

	/**
	 * Reading a File from a JAR
	 * 
	 * To read a file which is located inside a JAR file, we will need a JAR with a
	 * file inside it. For our example, we will read "IOUtils.class" or other
	 * “LICENSE.txt” from the “commons-io.jar ” file:
	 * 
	 * @throws IOException
	 */
	@Test
	public void whenReadUsing_JAR_thenCorrect() throws IOException {
		Class clazz = FileUtils.class;
		InputStream inputStream = clazz.getResourceAsStream("IOUtils.class");
		String data = readFromInputStream(inputStream);

		assertTrue(data.contains("Util"));
	}

	@Test
	public void whenReadUsing_FileContentsIntoString_thenCorrect() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder builder = new StringBuilder();
		String currentLine = reader.readLine();
		while (currentLine != null) {
			builder.append(currentLine);
			builder.append("\n");
			currentLine = reader.readLine();
		}

		reader.close();
		assertEquals(EXPECTED_DATA, builder.toString());
	}

	@Test
	public void whenReadUsing_LineNumberReader_thenCorrect() throws IOException {

		String expect = null;
		String line = null;
		try (LineNumberReader lineNumberReader2 = new LineNumberReader(new FileReader(file))) {
			line = lineNumberReader2.readLine();
			while (line != null) {
				System.out.println(line);
				line = lineNumberReader2.readLine();
			}
		}

		assertEquals(expect, line);
	}

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

	public void whenReadUsing_ReadByConsole_thenCorrect2() throws IOException {
		/**
		 * In JDK 6 and later, we can use the Console class from java.io package to read
		 * from and write to the console.
		 */
		Console console = System.console();
		String name = console.readLine("Enter your name: ");
		char[] pass = console.readPassword("To finish, enter password: ");
		console.printf(name + " welcome!");

	}

	@Test()
	public void whenReadUsing_SystemIn_thenCorrect() throws IOException {
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));
		// int i = Integer.parseInt(buffReader.readLine());
		Assertions.assertThrows(NumberFormatException.class, () -> {
			Integer i = Integer.parseInt(buffReader.readLine());
			if (i instanceof Integer) {
				// to simulate for all case
				throw new NumberFormatException();
			}
		});
	}

	private void fileWrappers() throws IOException {
		BufferedWriter b2 = new BufferedWriter(new FileWriter("f1"));
		BufferedWriter b3 = new BufferedWriter(new PrintWriter("f2"));
		Writer bw = null;// do it
		BufferedWriter b4 = new BufferedWriter(new BufferedWriter(bw));
	}

	@Test()
	public void whenReadUsing_XmlProperties_thenCorrect() throws IOException {
		Properties properties = new Properties();
		try (FileInputStream fileInputStream = new FileInputStream("props.xml")) {
			properties.loadFromXML(fileInputStream);
			System.out.println(properties);
			assertEquals("value3", properties.get("property3"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void whenReadUsing_ListFiles_thenCount() throws IOException {
		File search = new File("C:\\workspace-17\\java-in-deep");

		String[] files = search.list();
		for (String fn : files)
			System.out.println("found:  " + fn + "; nameLength = " + fn.length());
		assertEquals(25, files.length);

		Properties properties = getFoldersList();
		System.out.println();
		assertEquals("value2", properties.getProperty("property2"));
	}

	private Properties getFoldersList() throws FileNotFoundException, IOException {
		Properties p = new Properties();
		if (Files.exists(new File(file).toPath())) {
			FileInputStream in = new FileInputStream(new File("props.xml"));
			p.loadFromXML(in);
			BiConsumer<Object, Object> bi = (x, y) -> {
				p.getProperty(x.toString(), new File(y.toString()).getName());
			};
			p.forEach(bi);

		}
		return p;
	}

	@Test()
	public void whenReadUsing_PropertiesFromClassPath_thenCorrect() throws IOException {
		Properties properties = new Properties();
		try (InputStream inputStream = FileReadOptions.class.getResourceAsStream("props.properties")) {
			properties.load(inputStream);
			System.out.println(properties);
			assertEquals("value3", properties.get("property3"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test()
	public void whenReadUsing_WalkOnFiles() {
		// Java 7 Path.of
		Path path = Path.of(dirPath);
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

	@Test()
	// see main method as an equivalent
	public void whenReadUsing_FilteredFile() {
		// Java 7 Path.of
		Path path = Path.of("C:\\workspace-17\\java-in-deep\\src-practice\\net\\sahet\\java\\core\\lang\\blocks");
		// Java 8 Files.lines
		try (Stream<String> linesStream = Files.lines(path)) {
			Predicate<String> hasArray = s -> s.contains("@Test");
			linesStream.filter(hasArray).forEach(System.out::println);
		} catch (IOException e) {
			System.err.println("Err" + e);
		}
	}

	// see main method as an equivalent
	public void whenReadUsing_FilteredFile2() {
		// Java 7 Path.of
		// explicitly
		// Path path = Path.of("c:", filePath,
		// "\\src\\main\\java\\features\\in\\java9\\jshell");
		Path path = Path.of("C:\\workspace-17\\java-in-deep\\src-practice\\net\\sahet\\java\\core\\lang\\blocks");

		// Java 8 Files.lines
		try (Stream<String> linesStream = Files.lines(path)) {
			Predicate<String> hasArrow = s -> s.contains("==>");
			Predicate<String> pathOf = s -> !s.contains("filePath");
			linesStream.dropWhile(Predicate.not(hasArrow)) // .skip(1)
					.takeWhile(pathOf).forEach(System.out::println);
		} catch (IOException e) {
			System.err.println("Err" + e);
		}
	}

	// see above test as an equivalent
	public static void main(String[] args) {
		String filePath = "C:\\workspace-17\\java-in-deep\\src-practice\\net\\sahet\\java\\core\\lang\\blocks\\FileReadOptions.java";
		// Java 7
		try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
			// Java 8 br.lines()
			Stream<String> linesStream = br.lines();
			Predicate<String> hasArray = s -> s.contains("@Test");
			// linesStream.filter(Predicate.not(hasArray)).forEach(System.out::println);
			linesStream.filter(hasArray).forEach(System.out::println);
		} catch (IOException e) {
			System.err.println("Err" + e);
		}

	}
}

class Mgm {
	private String domain;
	private int accessCount;

	public Mgm(String domain, int accessCount) {
		this.domain = domain;
		this.accessCount = accessCount;
	}

	public String getDomain() {
		return domain;
	}

	public int getAccessCount() {
		return accessCount;
	}

	@Override
	public String toString() {
		return "domain: " + domain + "; accessCount:" + accessCount;
	}

}

class ReadWriteDemo {
	public static void main(String[] args) throws IOException {

		Reader reader = new FileReader(FileReadOptions.file);

		char[] theChars = new char[128];

		/**
		 * Reading an array of characters at a time is faster than reading a single
		 * character at a time from a Java Reader.
		 */
		int charsRead = reader.read(theChars, 0, theChars.length);
		while (charsRead != -1) {
			System.out.println(new String(theChars, 0, charsRead));
			charsRead = reader.read(theChars, 0, theChars.length);
		}

		/**
		 * Transparent Buffering via BufferedReader You can add transparent, automatic
		 * reading and buffering of an array of bytes from a Reader using a Java
		 * BufferedReader .
		 */
		try (BufferedReader br = new BufferedReader(new FileReader(FileReadOptions.file), 1024 * 1024)) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
