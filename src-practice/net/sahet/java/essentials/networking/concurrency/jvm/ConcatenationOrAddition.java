package net.sahet.java.essentials.networking.concurrency.jvm;

public class ConcatenationOrAddition {

}

class Feline {
    public static void main(String[] args) {
        Long x = 42L;
        Long y = 44L;
        Long z = 44L;
        System.out.println(y == z);
        System.out.println(y.equals(z));

        System.out.println(" " + 7 + 2 + " ");
        System.out.println(foo() + x + 5 + " ");
        System.out.println(x + y + foo());

        //
        int x2 = 5;
        int y2 = 7;
        System.out.println(((y2 * 2) % x2));
        System.out.println(" " + (y2 % x2));
    }

    static String foo() {
        return "foo";
    }
}
