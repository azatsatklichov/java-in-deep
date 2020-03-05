package net.sahet.designpatterns.creational.abstractfactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class AbstractFactoryDemo {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		System.out.println("\n	Abstract factory build-in classes ");
		/**
		 * Abstract factory is a Factory of factories
		 * 
		 * DocumentBuilder
		 * 
		 * Frameworks (heavily use it)
		 * 
		 */
		DocumentBuilderFactory abstractFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder factory = abstractFactory.newDocumentBuilder();
		Document doc1 = factory.newDocument();
		System.out.println(doc1);
		InputStream is = new FileInputStream("ps.xml"); // TBD just example
		// or
		Document doc2 = factory.parse(is);
		System.out.println(doc2.getNodeName());

	}
}
