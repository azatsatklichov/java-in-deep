package net.sahet.java.core.lang.building.blocks;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 * Properties
 * 
 * <pre>
 *  
Properties are configuration values managed as key/value pairs. In each pair, the key and value are both String values.
 The key identifies, and is used to retrieve, the value, much as a variable name is used to retrieve the variable's 
 value. For example, an application capable of downloading files might use a property named 
 "download.lastDirectory" to keep track of the directory used for the last download.
 * 
 * </pre>
 * 
 */
class PropertiesEg {

	public static void main(String[] args) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {

			output = new FileOutputStream("my-props.properties");

			// set the properties value
			prop.setProperty("database", "localhost");
			prop.setProperty("dbuser", "msasa");
			prop.setProperty("dbpassword", "password");

			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

}

class PropertiesRead {
	public static void main(String[] args) {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			// input = new FileInputStream("my-props.properties");
			// this reminded me Comba 
			input = new PropertiesRead().getClass().getResourceAsStream("/my-read-props.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("database"));
			System.out.println(prop.getProperty("dbuser"));
			System.out.println(prop.getProperty("dbpassword"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

class PropertiesTest {
	public static void main(String[] args) throws Exception {

		// set up new properties object
		// from file "myProperties.txt"
		FileInputStream propFile = new FileInputStream("myProperties.txt");
		Properties p = new Properties(System.getProperties());
		p.load(propFile);

		// set the system properties
		System.setProperties(p);
		// display new properties
		System.getProperties().list(System.out);
	}
}

class EnvVAriables {
	public static void main(String[] args) {
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n", envName, env.get(envName));
		}

		System.out.println("\nPassing Environment Variables to New Processes via ProcessBuilder ");
		/**
		 * When a Java application uses a ProcessBuilder object to create a new process,
		 * the default set of environment variables passed to the new process is the
		 * same set provided to the application's virtual machine process. The
		 * application can change this set using ProcessBuilder.environment.
		 */
		// new process
		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/C", "start");// , "mystuff.exe"
		Map<String, String> mp = pb.environment();
		mp.put("Path", "myPath");
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// or Take a look at the Apache Commons Exec project.
		String line = "myCommand.exe";
		/*
		 * CommandLine commandLine = CommandLine.parse(line); DefaultExecutor executor =
		 * new DefaultExecutor(); executor.setExitValue(1); int exitValue =
		 * executor.execute(commandLine);
		 */

	}
}

class CmdProcessBuilder {
	public static void main(String args[]) throws InterruptedException, IOException {
		List<String> command = new ArrayList<String>();
		command.add(args[0]);

		ProcessBuilder builder = new ProcessBuilder(command);
		Map<String, String> environ = builder.environment();

		final Process process = builder.start();
		InputStream is = process.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.out.println("Program terminated!");
	}
}

/**
 * The Preferences API allows applications to store and retrieve configuration
 * data in an implementation-dependent backing store. Asynchronous updates are
 * supported, and the same set of preferences can be safely updated by multiple
 * threads and even multiple applications. For more information, refer to the
 * Preferences API Guide.
 * 
 *
 */
class PreferencesAPI {

	private Preferences prefs;

	public static void main(String[] args) throws BackingStoreException {
		System.out.println("The Preferences API allows applications to store and retrieve configuration data in an "
				+ "\nimplementation-dependent backing store. Asynchronous updates are supported, and the same set of preferences can be safely updated by multiple threads and even multiple applications.");
		System.out.println(
				"The class java.util.ServiceLoader provides a simple service provider facility. A service provider is an implementation of a service � a well-known set of interfaces and (usually abstract) classes. ");

		System.out.println(
				"The Java Preferences API provides a systematic way to handle program preference configurations, e.g. to save user settings, remember the last value of a field etc.");

		System.out.println();

		PreferencesAPI test = new PreferencesAPI();
		test.setPreference();

		System.out.println();
		System.out.println();
		Preferences systemRoot = Preferences.systemRoot();

		Preferences preferences = getPrefs(); // systemRoot.node("com/mycompany/settings");
		System.out.println(preferences.get("Test1", null));

		systemRoot.put("foo", "bar");
		systemRoot.put("baz", "lolz");
		System.out.println("-------------------------------");

		String[] keys = preferences.keys();
		for (String key : keys) {
			System.out.println(key);
		}

		System.out.println("-------------------------------");

		keys = systemRoot.keys();
		for (String key : keys) {
			System.out.println(key);
		}

	}

	public void setPreference() {
		// This will define a node in which the preferences can be stored
		prefs = Preferences.userRoot().node(this.getClass().getName());
		String ID1 = "Test1";
		String ID2 = "Test2";
		String ID3 = "Test3";

		// First we will get the values
		// Define a boolean value
		System.out.println(prefs.getBoolean(ID1, true));
		// Define a string with default "Hello World
		System.out.println(prefs.get(ID2, "Hello World"));
		// Define a integer with default 50
		System.out.println(prefs.getInt(ID3, 50));

		// now set the values
		prefs.putBoolean(ID1, false);
		prefs.put(ID2, "Hello Europa");
		prefs.putInt(ID3, 45);

		System.out.println(prefs);
		System.out.println(prefs.get(ID2, "Hello Europa"));
		// Delete the preference settings for the first value
		prefs.remove(ID1);

	}

	private static Preferences getPrefs() {
		return Preferences.userRoot().node(new PropertiesEg().getClass().getName());
	}

}

class PreferenceTest {
	private Preferences prefs;

	public void setPreference() {
		// This will define a node in which the preferences can be stored
		prefs = Preferences.userRoot().node(this.getClass().getName());
		String ID1 = "Test1";
		String ID2 = "Test2";
		String ID3 = "Test3";

		// First we will get the values
		// Define a boolean value
		System.out.println(prefs.getBoolean(ID1, true));
		// Define a string with default "Hello World
		System.out.println(prefs.get(ID2, "Hello World"));
		// Define a integer with default 50
		System.out.println(prefs.getInt(ID3, 50));

		// now set the values
		prefs.putBoolean(ID1, false);
		prefs.put(ID2, "Hello Europa");
		prefs.putInt(ID3, 45);

		// First we will get the values
		// Define a boolean value
		System.out.println(prefs.getBoolean(ID1, true));
		// Define a string with default "Hello World
		System.out.println(prefs.get(ID2, "Hello World"));
		// Define a integer with default 50
		System.out.println(prefs.getInt(ID3, 50));

		System.out.println("-- stays in MEMORY --");
		/**
		 * The Java Preferences API provides a systematic way to handle program
		 * preference configurations, e.g. to save user settings, remember the last
		 * value of a field etc.
		 * 
		 * https://www.vogella.com/tutorials/JavaPreferences/article.html
		 */

		System.out.println("Where Preferences Stored - in registry");
		/**
		 * HKEY_LOCAL_MACHINE\SOFTWARE\JavaSoft\Prefs
		 * 
		 * Preferences systemRoot = Preferences.systemRoot();
		 * 
		 * Preferences preferences = systemRoot.node( "com/mycompany/settings" );
		 * 
		 * Under 32bit OS (Windows XP in my case) the systemRoot registry path was
		 * 
		 * HKEY_LOCAL_MACHINE\SOFTWARE\JavaSoft\Prefs
		 * 
		 * Broadcom says: HKEY_CURRENT_USER\Software\JavaSoft\Prefs
		 * 
		 * Under 64bit OS (Windows 7 in my case) the systemRoot registry path was
		 * 
		 * HKEY_LOCAL_MACHINE\SOFTWARE\Wow6432Node\JavaSoft\Prefs
		 * 
		 * Some preferences are stored in registry keys, while some others (now I'm
		 * going to check exactly which ones) seem stored in text files; for instance,
		 * the preference "Use certificates and keys in browser keystore" is stored in
		 * C:\Users\%USER%\AppData\LocalLow\Sun\Java\Deployment\deployment.properties :
		 * 
		 * https://resources.mpi-inf.mpg.de/d5/teaching/ss05/is05/javadoc/java/util/prefs/WindowsPreferences.html
		 * 
		 * https://www.java.com/en/download/help/win_controlpanel.html
		 */

		// Delete the preference settings for the first value
		prefs.remove(ID1);

	}

	public static void main(String[] args) {
		PreferenceTest test = new PreferenceTest();
		test.setPreference();
	}
}

class XmlPropExample {
	public static void main(String[] args) {

		Properties props = new Properties();
		try (FileOutputStream output = new FileOutputStream("props.xml")) {
			props.storeToXML(output, "These are comments");
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("--- from XML prop");
		try (FileInputStream fileInputStream = new FileInputStream("props.xml")) {
			props.loadFromXML(fileInputStream);
			System.out.println(props.getProperty("comments"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class PathExamples {

	public static void main(String[] args) {

	}
}

class ConfigPropertiesDemo {

	public static void main(String[] args) {
		Properties properties = new Properties();

		properties.setProperty("property1", "value1");
		properties.setProperty("property2", "value2");
		properties.setProperty("property3", "value3");

		try (FileWriter output = new FileWriter("props.properties")) {
			properties.store(output, "These are properties");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// try (FileWriter output = new FileWriter("props.properties",
		// Charset.forName("UTF-8"))) {
		// properties.store(output, "These are properties");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		properties = new Properties();

		try (FileReader fileReader = new FileReader("props.properties")) {
			properties.load(fileReader);
			System.out.println(properties);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileOutputStream output = new FileOutputStream("props.xml")) {
			properties.storeToXML(output, "These are properties");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// try(FileOutputStream output = new FileOutputStream("data/props.xml")){
		// properties.storeToXML(output, "These are properties",
		// Charset.forName("ISO-8859-1"));
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		properties = new Properties();
		try (FileInputStream fileInputStream = new FileInputStream("props.xml")) {
			properties.loadFromXML(fileInputStream);
			System.out.println(properties);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.setProperty("key1", "value1");
		String value1 = System.getProperty("key1");

		System.out.println(value1);

		// The above is equal to:

		Properties systemProperties = System.getProperties();
		systemProperties.forEach((x, y) -> System.out.println("" + x + "=" + y));
		systemProperties.forEach((key, val) -> System.out.println("[" + key + "] " + val));

		systemProperties.setProperty("key1", "value1");
		value1 = systemProperties.getProperty("key1");
		System.out.println(value1);
	}
}
