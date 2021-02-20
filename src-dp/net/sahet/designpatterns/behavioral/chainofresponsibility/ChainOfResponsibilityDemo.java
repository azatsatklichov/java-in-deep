package net.sahet.designpatterns.behavioral.chainofresponsibility;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChainOfResponsibilityDemo {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) {
		System.out.println("\n	Chain of Responsibility Pattern example ");

		LineData line = new LineData(new double[] { 1.0, 2.0, 1.0, 2.0, -1.0, 3.0, 4.0, 5.0, 4.0 });
		MinimaFinder mf = new MinimaFinder();
		LineData solve = mf.solve(line);
		System.out.println(Arrays.toString(solve.data));

		System.out.println("\n	Chain of Responsibility Java build-in classes ");
		/**
		 * java.util.logging.Logger#log()
		 * 
		 * javax.servlet.Filter#doFilter()
		 * 
		 * Frameworks (Spring Security filter Chain)
		 * 
		 */
		setLogLevel();

	}

	public static void setLogLevel() {

		// include only SEVERE
		LOGGER.setLevel(Level.SEVERE);
		LOGGER.severe("Severe Log");
		LOGGER.warning("Warning Log");
		LOGGER.info("Info Log");
		LOGGER.fine("Fine log");
		LOGGER.finer("Finer log");
		LOGGER.finest("Finest log");
		System.out.println("---");

		// include FINER, only FINEST excluded
		LOGGER.setLevel(Level.FINER);
		LOGGER.severe("Severe Log");
		LOGGER.warning("Warning Log");
		LOGGER.info("Info Log");
		LOGGER.fine("Fine log");
		LOGGER.finer("Finer log");
		LOGGER.finest("Finest log");
		System.out.println("---");

		// Once INFO included, then severe, warning and info will be included
		// finest is out
		LOGGER.setLevel(Level.INFO);
		LOGGER.severe("Severe Log");
		LOGGER.warning("Warning Log");
		LOGGER.info("Info Log");
		LOGGER.fine("Fine log");
		LOGGER.finer("Finer log");
		LOGGER.finest("Finest log");
	}

}
