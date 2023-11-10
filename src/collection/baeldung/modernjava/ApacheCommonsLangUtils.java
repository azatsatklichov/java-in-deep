package collection.baeldung.modernjava;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.apache.commons.lang3.math.Fraction;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.jupiter.api.Test;

//https://www.baeldung.com/java-commons-lang-3
public class ApacheCommonsLangUtils {

	@Test
	public void whenCalledisBlank_thenCorrect() {
		assertTrue(StringUtils.isBlank(" "));
	}

	@Test
	public void whenCalledisEmpty_thenCorrect() {
		assertTrue(StringUtils.isEmpty(""));
	}

	@Test
	public void whenCalledisAllLowerCase_thenCorrect() {
		assertTrue(StringUtils.isAllLowerCase("abd"));
	}

	@Test
	public void whenCalledisAllUpperCase_thenCorrect() {
		assertTrue(StringUtils.isAllUpperCase("ABC"));
	}

	@Test
	public void whenCalledisMixedCase_thenCorrect() {
		assertTrue(StringUtils.isMixedCase("abC"));
	}

	@Test
	public void whenCalledisAlpha_thenCorrect() {
		assertTrue(StringUtils.isAlpha("abc"));
	}

	@Test
	public void whenCalledisAlphanumeric_thenCorrect() {
		assertTrue(StringUtils.isAlphanumeric("abc123"));
	}

	@Test
	public void whenCalledtoString_thenCorrect() {
		String[] array = { "a", "b", "c" };
		String string = ArrayUtils.toString(array);
		System.out.println(string);
		assertEquals(string, "{a,b,c}");
	}

	@Test
	public void whenCalledtoStringIfArrayisNull_thenCorrect() {
		assertEquals(ArrayUtils.toString(null, "Array is null"), "Array is null");
	}

	@Test
	public void whenCalledhashCode_thenCorrect() {
		String[] array = { "a", "b", "c" };
		assertEquals(ArrayUtils.hashCode(array), 997619);
	}

	@Test
	public void whenCalledtoMap_thenCorrect2() {
		String[][] array = { { "1", "one", }, { "2", "two", }, { "3", "three" } };
		Map map = new HashMap();
		map.put("1", "one");
		map.put("2", "two");
		map.put("3", "three");

//		/assertEquals(ArrayUtils.toMap(array)), map);
	}

	@Test
	public void whenCalledisSameLength_thenCorrect() {
		int[] array1 = { 1, 2, 3 };
		int[] array2 = { 1, 2, 3 };
		assertTrue(ArrayUtils.isSameLength(array1, array2));
	}

	@Test
	public void whenCalledIndexOf_thenCorrect() {
		int[] array = { 1, 2, 3 };
		assertEquals(ArrayUtils.indexOf(array, 1, 0), 0);
	}

	@Test
	public void whenCalledcompareWithIntegers_thenCorrect() {
		assertEquals(NumberUtils.compare(1, 1), 0);
	}

	@Test
	public void whenCalledcompareWithLongs_thenCorrect() {
		assertEquals(NumberUtils.compare(1L, 1L), 0);
	}

	@Test
	public void whenCalledcreateNumber_thenCorrect() {
		assertEquals(NumberUtils.createNumber("123456"), 123456);
	}

	@Test
	public void whenCalledisDigits_thenCorrect() {
		assertTrue(NumberUtils.isDigits("123456"));
	}

	@Test
	public void whenCalledmaxwithIntegerArray_thenCorrect() {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		assertEquals(NumberUtils.max(array), 6);
	}

	@Test
	public void whenCalledminwithIntegerArray_thenCorrect() {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		assertEquals(NumberUtils.min(array), 1);
	}

	@Test
	public void whenCalledminwithByteArray_thenCorrect() {
		byte[] array = { 1, 2, 3, 4, 5, 6 };
		assertEquals(NumberUtils.min(array), (byte) 1);
	}

	@Test
	public void whenCalledgetFraction_thenCorrect() {
		assertEquals(Fraction.getFraction(5, 6), 0.83);
	}

	@Test
	public void givenTwoFractionInstances_whenCalledadd_thenCorrect() {
		Fraction fraction1 = Fraction.getFraction(1, 4);
		Fraction fraction2 = Fraction.getFraction(3, 4);
		assertEquals(fraction1.add(fraction2).toString(), "1/1");
	}

	@Test
	public void givenTwoFractionInstances_whenCalledsubstract_thenCorrect() {
		Fraction fraction1 = Fraction.getFraction(3, 4);
		Fraction fraction2 = Fraction.getFraction(1, 4);
		assertEquals(fraction1.subtract(fraction2).toString(), "1/2");
	}

	@Test
	public void givenTwoFractionInstances_whenCalledmultiply_thenCorrect() {
		Fraction fraction1 = Fraction.getFraction(3, 4);
		Fraction fraction2 = Fraction.getFraction(1, 4);
		assertEquals(fraction1.multiplyBy(fraction2).toString(), "3/16");
	}

	@Test
	public void whenCalledgetJavaHome_thenCorrect() {
		assertEquals(SystemUtils.getJavaHome(), new File("C:\\Apps\\Java\\jdk-13")); // path/to/java/jdk
	}

	@Test
	public void whenCalledgetUserHome_thenCorrect() {
		assertEquals(SystemUtils.getUserHome(), new File("C:\\users\\ASUS"));
	}

	@Test
	public void whenCalledisJavaVersionAtLeast_thenCorrect() {
		assertEquals(SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_RECENT), true);
	}

	// Now, if we want to get our costly User object when it's required, we just
	// call the UserInitializer's get() method:
	/**
	 * The get() method is an implementation of the double-check idiom (thread-safe)
	 * for an instance field, as specified in Joshua Bloch's â€œEffective Javaâ€?, item
	 * 71:
	 * 
	 * User get() { if (instance == null) { synchronized(this) { if (instance ==
	 * null) instance = new User("John", "john@domain.com"); } } } return instance;
	 * }
	 * 
	 * @throws ConcurrentException
	 */
	@Test
	public void whenCalledget_thenCorrect() throws ConcurrentException {
		UserInitializer userInitializer = new UserInitializer();
		User user = userInitializer.get();

		assertTrue(user instanceof User);
	}

	@Test
	public void whenCalledtoHashCode_thenCorrect() {
		int hashcode = new HashCodeBuilder(17, 37).append("John").append("john@domain.com").toHashCode();
		assertEquals(hashcode, 1269178828);

	}

	@Test
	public void whenCalledgetAccessibleConstructor_thenCorrect() {
		Constructor<User> accessibleConstructor = ConstructorUtils.getAccessibleConstructor(User.class, String.class,
				String.class);

		// assertTrue(accessibleConstructor instanceof Constructor.class);
	}

	/*
	 * @Test public void whenCalledgetField_thenCorrect() {
	 * assertEquals(FieldUtils.getField(User.class, "name", true).getName(),
	 * "name"); }
	 */
	 
	
	@Test
	public void whenCalledgetAccessibleMethod_thenCorrect() {
	    assertTrue(MethodUtils.getAccessibleMethod(User.class, "getName") instanceof Method);
	}	

}

/**
 * The Lazy Initialization and Builder Classes One of Apache Commons Lang 3's
 * most appealing facet is the implementation of some well-known design
 * patterns, including the lazy-initialization and builder patterns.
 */
class UserInitializer extends LazyInitializer<User> {

	@Override
	protected User initialize() {
		return new User("John", "john@domain.com");
	}

}

class User {

	private String name;
	private String email;

	public User(String name, String email) {
		this.name = name;
		this.email = email; 
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}