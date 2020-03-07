package net.sahet.designpatterns.behavioral.strategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StrategyDemo {
	public static void main(String[] args) {
		System.out.println("\n	Strategy pattern example ");
		PaymentCard visaCard = new PaymentCard(new VisaCardValidator());
		setCardValue(visaCard, "Akys Saparow", "4234545366557890", "02/2022", "561");
		System.out.println(visaCard.getCardValidator().isValid(visaCard));

		PaymentCard masterCard = new PaymentCard(new MasterCardValidator());
		setCardValue(masterCard, "Merdan Saparow", "52345453667890", "11/2023", "274");
		System.out.println(visaCard.getCardValidator().isValid(masterCard));

		System.out.println("\n	Strategy Java build-in classes");
		/**
		 * java.util.Comparator
		 * 
		 */
		System.out.println("Lambda way");
		Stream.of(1, 4, 2, 5).sorted(Comparator.reverseOrder());
		Stream.of("foo", "test", "a").sorted(Comparator.comparingInt(String::length).reversed());

		List<Integer> ints = Arrays.asList(new Integer[] { 34, 5, -5, 55, 6 });
		Integer min = ints.stream().min(Comparator.comparing(item -> item)).get();
		System.out.println(min);

		System.out.println("Standard way");
		Student[] studentsArr = new Student[] { new Student("Zeynep", 23), new Student("Gulsirin", 24),
				new Student("Cemen", 37), new Student("Senem", 22), new Student("Dilber", 27),
				new Student("Sadap", 22) };
		List<Student> students = Arrays.asList(studentsArr);

		// immutable, you can not sort even
		/*
		 * List<Student> students = List.of(new Student("Zeynep", 23), new
		 * Student("Gulsirin", 24), new Student("Cemen", 37), new Student("Senem", 22),
		 * new Student("Dilber", 27), new Student("Sadap", 22));
		 */
		System.out.println(students);
		Collections.sort(students, new Student.StudentComparator());
		System.out.println(students);

		// reverse sort
		Collections.sort(students, Collections.reverseOrder(new Student.StudentComparator()));
		System.out.println(students);

		// comparator anonymous method
		Collections.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				int cmpByName = s1.getName().compareTo(s2.getName());
				return cmpByName != 0 ? cmpByName : Integer.compare(s1.getAge(), s2.getAge());
			}

		});
		System.out.println(students);

	}

	private static void setCardValue(PaymentCard card, String holderName, String number, String issueDate, String cvv) {
		card.setHolderName(holderName);
		card.setNumber("4234545366557890");
		card.setIssueDate("04/2020");
		card.setCvv("561");
	}
}

class Student {
	String name;
	int age;

	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer[" + "Name=" + name + ", Age=" + age + ']';
	}

	static class StudentComparator implements Comparator<Student> {

		@Override
		public int compare(Student s1, Student s2) {
			int cmpByName = s1.getName().compareTo(s2.getName());
			return cmpByName != 0 ? cmpByName : Integer.compare(s1.getAge(), s2.getAge());
		}
	}
}