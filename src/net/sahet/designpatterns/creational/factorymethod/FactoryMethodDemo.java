package net.sahet.designpatterns.creational.factorymethod;

import java.util.Calendar;
import java.util.Locale;

public class FactoryMethodDemo {
	public static void main(String[] args) {

		System.out.println("\n	Factory method Java build-in classes ");
		/**
		 * Calendar
		 * 
		 * ResourceBundle
		 * 
		 * List.of(), Set.of()
		 * 
		 * NumberFormat, ...
		 * 
		 */
		Calendar cal1 = Calendar.getInstance();
		System.out.println(cal1.getCalendarType());
		System.out.println(cal1.get(Calendar.DAY_OF_MONTH));

		Locale locale = new Locale("ja", "JP", "JP");
		Calendar cal2 = Calendar.getInstance(locale);
		System.out.println(cal2.getCalendarType());
		System.out.println(cal2.get(Calendar.DAY_OF_MONTH));
	}
}
