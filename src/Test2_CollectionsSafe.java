package net.sahet.iviews;

import java.util.ArrayList;
import java.util.List;

public class Test2_CollectionsSafe {
	public void addAnimal(List<Animal> animals) {
		animals.add(new Dog()); // still OK as always
	}

	public static void main(String[] args) {
		List<Dog> animals = new ArrayList<Dog>();
		animals.add(new Dog());
		animals.add(new Dog());
		AnimalDoctorGeneric doc = new AnimalDoctorGeneric();
	    doc.addAnimal(animals); // THIS is where it breaks!, compiletime error
	    System.out.println(animals);
	    System.out.println("test");
	}

}
