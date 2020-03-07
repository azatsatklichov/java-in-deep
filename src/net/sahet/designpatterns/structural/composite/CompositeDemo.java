package net.sahet.designpatterns.structural.composite;

import java.util.HashMap;
import java.util.Map;

public class CompositeDemo {
	public static void main(String[] args) {
		System.out.println("\n	Composite design pattern example ");
		Menu mainMenu = new Menu("Main", "/main");

		SubMenu safetyMenuItem = new SubMenu("Safety", "/safety");

		mainMenu.add(safetyMenuItem);

		Menu claimsSubMenu = new Menu("Claims", "/claims");

		mainMenu.add(claimsSubMenu);

		SubMenu claimsSubSubMenu = new SubMenu("Personal Claim", "/personalClaims");

		claimsSubMenu.add(claimsSubSubMenu);

		System.out.println(mainMenu.toString());

		System.out.println("\n2-example");
		System.out.println("run Test()");

		System.out.println();
		System.out.println("\n	Composite Java build-in classes ");
		/**
		 * java.awt.Component
		 * 
		 * JSF widgeds
		 * 
		 * 
		 * RESTfull services GETs
		 */
		Map<String, String> map1 = new HashMap<>();
		map1.put("a", "auto");
		map1.put("A", "AUTO");
		System.out.println(map1);

		Map<String, String> map2 = new HashMap<>();
		map2.put("b", "bus");
		map2.put("B", "BUS");
		System.out.println(map2);

		Map<String, String> map3 = new HashMap<>();
		map3.putAll(map1);
		map3.putAll(map2);
		System.out.println(map3);

	}
}

class Test {
	public static void main(String[] args) {
		Employee boss = new Employee("CEO", 200000, false);
		Employee marketVP = new Employee("Marketing VP", 100000, false);
		boss.add(marketVP);
		Employee prodVP = new Employee("Production VP", 100000, false);
		boss.add(prodVP);
		
		
		Employee salesMgr = new Employee("Sales Mgr", 50000, false);
		marketVP.add(salesMgr);
		Employee advMgr = new Employee("Advt Mgr", 50000, true);
		marketVP.add(advMgr);
		// add salesmen reporting to Sales Manager
		for (int i = 0; i < 5; i++)
			salesMgr.add(new Employee("Sales " + new Integer(i).toString(),
					30000.0F + (float) (Math.random() - 0.5) * 10000, true));
		
		
		advMgr.add(new Employee("Secy", 20000, false));
		Employee prodMgr = new Employee("Prod Mgr", 40000, false);
		prodVP.add(prodMgr);
		Employee shipMgr = new Employee("Ship Mgr", 35000, false);
		prodVP.add(shipMgr);
		// add manufacturing staff
		for (int i = 0; i < 4; i++)
			prodMgr.add(new Employee("Manuf " + new Integer(i).toString(),
					25000.0F + (float) (Math.random() - 0.5) * 5000, true));
		// add shipping clerks
		for (int i = 0; i < 3; i++)
			shipMgr.add(new Employee("ShipClrk " + new Integer(i).toString(),
					20000.0F + (float) (Math.random() - 0.5) * 5000, true));
		


		System.out.println(boss.subordinates);
		 System.out.println(marketVP.subordinates); 
		System.out.println(prodVP.subordinates);
		System.out.println(advMgr.subordinates);
		System.out.println(salesMgr.subordinates);
		System.out.println(prodMgr.subordinates);
		System.out.println(shipMgr.subordinates);
	}
}
