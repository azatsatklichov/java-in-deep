package net.sahet.designpatterns.structural.composite;

import java.util.List;
import java.util.Vector;

public class Employee {
	String name;
	float salary;
	List<Employee> subordinates;
	public boolean isLeaf;

	public Employee(String _name, float _salary, boolean isLeaf) {
		name = _name;
		salary = _salary;
		subordinates = new Vector();
		this.isLeaf = isLeaf;
	}

	public float getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

	public void remove(Employee e) {
		subordinates.remove(e);
	}

	public float getSalaries() {
		float sum = salary;
		for (int i = 0; i < subordinates.size(); i++) {
			sum += subordinates.get(i).getSalaries();
		}
		return sum;
	}

	public void setLeaf(boolean b) {
		isLeaf = b;
	}

	public boolean add(Employee e) {
		if (!isLeaf)
			subordinates.add(e);
		return isLeaf;
	}
	
	@Override
	public String toString() {
		return "Emp[name="+name+", salary="+salary+", subordinates="+subordinates+"]";
	}
}
