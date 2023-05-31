
public class TestEquals {

	public static void main(String[] args) {
		String s1 = "mary";
		String s2 = "mary";
		if (s1 == s2)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");

		if (s1.equals(s2))
			System.out.println("TRUE");
		else
			System.out.println("FALSE");

		String s3 = new String("mary");
		String s4 = new String("mary");

		if (s3 == s4)
			System.out.println("TRUE");
		else
			System.out.println("FALSE");

		if (s3.equals(s4))
			System.out.println("TRUE");
		else
			System.out.println("FALSE");

	}
}
