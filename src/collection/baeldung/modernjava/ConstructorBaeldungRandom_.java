package collection.baeldung.modernjava;

import java.security.SecureRandom;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Haywan {
    String name;

    Haywan(String name) {
        // Key Rule: The first line in a constructor must be a call to super()
        // or a call to this().
        super(); // anyway this is put implicitly by compiler, even if you do not write
        this.name = name;
        /// this(); //you can not use both this() and super()
    }

    Haywan() {
        this(makeRandomName());
    }

    static String makeRandomName() {
        int x = (int) (Math.random() * 5);
        String name = new String[] { "Fluffy", "Fido", "Rover", "Spike", "Gigi" }[x];
        return name;
    }

    public static void main(String[] args) {
        Haywan a = new Haywan();
        System.out.println(a.name);
        Haywan b = new Haywan("Zeus");
        System.out.println(b.name);
    }

}

class BaeldungRandom {

    public static void main(String[] args) {
        Instant hundredYearsAgo = Instant.now().minus(Duration.ofDays(100 * 365));
        Instant tenDaysAgo = Instant.now().minus(Duration.ofDays(10));
        Instant random = between(hundredYearsAgo, tenDaysAgo);
        System.out.println(random);
    }

    public static Instant between(Instant startInclusive, Instant endExclusive) {
        long startSeconds = startInclusive.getEpochSecond();
        long endSeconds = endExclusive.getEpochSecond();
        long random = ThreadLocalRandom.current().nextLong(startSeconds, endSeconds);

        return Instant.ofEpochSecond(random);
    }

    public static Instant after(Instant startInclusive) {
        return between(startInclusive, Instant.MAX);
    }

    public static Instant before(Instant upperExclusive) {
        return between(Instant.MIN, upperExclusive);
    }
}

/**
 * https://www.baeldung.com/java-generating-random-numbers
 * 
 * https://www.baeldung.com/java-secure-random
 */
class RandomNumbers {
    public static void main(String[] args) {
        System.out.println(getRandomNumber(12, 67));
        System.out.println(getRandomNumberUsingNextInt(12, 67));

        System.out.println(getRandomNumberUsingInts(12, 67));
        
        getSecureRandom();

    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int getRandomNumberUsingNextInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static int getRandomNumberUsingInts(int min, int max) {
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }

    public static void getSecureRandom() {
        SecureRandom secureRandom = new SecureRandom();
        int randomInt = secureRandom.nextInt();
        long randomLong = secureRandom.nextLong();
        float randomFloat = secureRandom.nextFloat();
        double randomDouble = secureRandom.nextDouble();
        boolean randomBoolean = secureRandom.nextBoolean();

        System.out
                .println(randomInt + "; " + randomLong + "; " + 
        randomFloat + ";" + randomDouble + ";" + randomBoolean);
    }
}