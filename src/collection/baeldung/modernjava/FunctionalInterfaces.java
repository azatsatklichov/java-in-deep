package collection.baeldung.modernjava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.baeldung.com/java-8-functional-interfaces
 *
 */
public class FunctionalInterfaces {
	public static void main(String[] args) {

		System.out.println("\n Functions  (T) -> R");
		/**
		 * 
		 * 
		 * The most simple and general case of a lambda is a functional interface with a
		 * method that receives one value and returns another. This function of a single
		 * argument is represented by the Function interface which is parameterized by
		 * the types of its argument and a return value:
		 * 
		 * public interface Function<T, R> { … }
		 */
		Map<String, Integer> nameMap = new HashMap<>();
		Integer value = nameMap.computeIfAbsent("John", s -> s.length());
		System.out.println(value);
		value = nameMap.computeIfAbsent("Johny", s -> {
			return s.length() + s.length();
		});

		// via method reference
		value = nameMap.computeIfAbsent("Jimmy", String::length);

		System.out.println(nameMap);
		Function<Integer, String> intToString = Object::toString;
		Function<String, String> quote = s -> "'" + s + "'";

		/**
		 * The Java Function compose() method composes a new Function instance from the
		 * Function instance it is called on, and the Function instance passed as
		 * parameter to the compose() method.
		 */
		Function<Integer, String> quoteIntToString = quote.compose(intToString);
		System.out.println("'5'".equals(quoteIntToString.apply(5)));

		System.out.println("\n Primitive Function Specializations");
		/**
		 * IntFunction, LongFunction, DoubleFunction: arguments are of specified type,
		 * return type is parameterized ToIntFunction, ToLongFunction, ToDoubleFunction:
		 * return type is of specified type, arguments are parameterized
		 * DoubleToIntFunction, DoubleToLongFunction, IntToDoubleFunction,
		 * IntToLongFunction, LongToIntFunction, LongToDoubleFunction — having both
		 * argument and return type defined as primitive types, as specified by their
		 * names.
		 * 
		 * BiFunction has both arguments and a return type generified, while
		 * ToDoubleBiFunction and others allow you to return a primitive value.
		 */
		System.out.println("\n Two-Arity Function Specializations - BiFunctional");
		Map<String, Integer> salaries = new HashMap<>();
		salaries.put("John", 40000);
		salaries.put("Freddy", 30000);
		salaries.put("Samuel", 50000);

		salaries.replaceAll((key, oldValue) -> key.equals("Freddy") ? oldValue : oldValue + 10000);
		System.out.println(salaries);

		System.out.println("\n Suppliers ");
		/**
		 * The Supplier functional interface is yet another Function specialization that
		 * does not take any arguments. It is typically used for lazy generation of
		 * values. For instance, let's define a function that squares a double value. It
		 * will receive not a value itself, but a Supplier of this value:
		 */
		Supplier<Double> lazyValue = () -> {
			System.out.println("Her havzun dibi aynidir");
			return 9d;
		};

		Double valueD = lazyValue.get();
		System.out.println("valueD = " + valueD);

		int[] fibs = { 0, 1 };
		Stream<Integer> fibonacci = Stream.generate(() -> {
			int result = fibs[1];
			int fib3 = fibs[0] + fibs[1];
			fibs[0] = fibs[1];
			fibs[1] = fib3;
			return result;
		}).limit(23);
		// fibonacci.forEach(System.out::println);

		fibonacci.forEach(x -> {
			System.out.print(x + ",  ");
		});

		System.out.println("\n\n  Consumer");
		/**
		 * Consumers As opposed to the Supplier, the Consumer accepts a generified
		 * argument and returns nothing. It is a function that is representing side
		 * effects.
		 * 
		 * For instance, let’s greet everybody in a list of names by printing the
		 * greeting in the console. The lambda passed to the List.forEach method
		 * implements the Consumer functional interface:
		 */
		List<String> names = Arrays.asList("John", "Freddy", "Samuel");
		names.forEach(name -> System.out.println("Hello, " + name));

		Map<String, Integer> ages = new HashMap<>();
		ages.put("John", 25);
		ages.put("Freddy", 24);
		ages.put("Samuel", 30);

		ages.forEach((name, age) -> System.out.println(name + " is " + age + " years old"));

		System.out.println("\n   Predicates");
		/**
		 * Predicates In mathematical logic, a predicate is a function that receives a
		 * value and returns a boolean value.
		 * 
		 * The Predicate functional interface is a specialization of a Function that
		 * receives a generified value and returns a boolean. A typical use case of the
		 * Predicate lambda is to filter a collection of values: *
		 */
		names = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");
		List<String> namesWithA = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
		System.out.println(namesWithA);

		System.out.println("\n   Operators");
		/**
		 * Operator interfaces are special cases of a function that receive and return
		 * the same value type. The UnaryOperator interface receives a single argument.
		 * One of its use cases in the Collections API is to replace all values in a
		 * list with some computed values of the same type:
		 */
		names.replaceAll(name -> name.toUpperCase());
		// or
		names.replaceAll(String::toUpperCase);
		System.out.println(names);

		List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);

		/**
		 * BinaryOperator is a reduction operation. Use the reduce method.
		 */
		int sum = values.stream().reduce(0, (i1, i2) -> i1 + i2);
		System.out.println(sum);

		System.out.println("\n  Legacy Functional Interfaces");
		/**
		 * Not all functional interfaces appeared in Java 8. Many interfaces from
		 * previous versions of Java conform to the constraints of a FunctionalInterface
		 * and can be used as lambdas.
		 */
		Thread thread = new Thread(() -> System.out.println("Hello From Another Thread"));
		thread.start();
		

	}

}
