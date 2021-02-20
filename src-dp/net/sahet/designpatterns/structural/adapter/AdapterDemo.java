package net.sahet.designpatterns.structural.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdapterDemo {
	public static void main(String[] args) {

		System.out.println("\n	Adapter design pattern example ");
		List<Report> employeeList = new ArrayList<>();

		// default report, no need conversion (adapter)
		Report defaultReport = new DefaultReport("1", "Niloya", "Potos teyze", "niloya@sahet.net");
		employeeList.add(defaultReport);

		// All below reports must be adapted
		LdapReport ldapReport = new LdapReport("2", "Maysa", "Suvxanova", "maysa@sahet.net");
		Report adaptedLdapReport = new LdapReportAdapter(ldapReport);
		employeeList.add(adaptedLdapReport);

		CsvReport csvReport = new CsvReport("3,Tospik,Tospaga,tospik@sahet.net");
		Report adaptedCsvReport = new CsvReportAdapter(csvReport);
		employeeList.add(adaptedCsvReport);

		DbReport dbReport = new DbReport("4", "Mete", "Hasan dayi", "mete@sahet.net");
		Report adaptedDbReport = new DbReportAdapter(dbReport);
		employeeList.add(adaptedDbReport);

		System.out.println(employeeList);

		System.out.println("\n	Adapter Java build-in classes ");
		/**
		 * Arrays -> List (Array adapts to List)
		 * 
		 * Streams has full of adapter methods
		 * 
		 */
		Integer[] intArrs = new Integer[] { 34, 3, -45, 67, 87 };
		List<Integer> intList = Arrays.asList(intArrs);
		System.out.println(intArrs);
		System.out.println(intList);
	}
}
