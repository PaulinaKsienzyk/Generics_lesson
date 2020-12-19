package comparisons;

import static comparisons.Comparator.Result.*;

public class Comparator {

    public static void main(String[] args) {
        System.out.println(compare(1, 0));
        System.out.println(compare(Integer.valueOf(5), Integer.valueOf(10)));
        System.out.println(compare("hi", "lower"));

// Generics are essential to detect errors at compile time.
// Without generics, there can be a problem with casting.
//        Since java 7 we can have empty angle brackets
    }

    public static String compare(int int1, int int2) {
        if (int1 == int2) {
            return EQUAL.toString();
        } else if (int1 > int2) {
            return HIGHER.toString();
        }
        return LOWER.toString();

    }

    public static String compare(Integer integer1, Integer integer2) {
        if (integer1.equals(integer2)) {
            return EQUAL.toString();
        } else if (integer1 > integer2) {
            return HIGHER.toString();
        }
        return LOWER.toString();
    }

    public static String compare(String str1, String str2) {
        if (str1.equals(str2)) {
            return EQUAL.toString();
        } else if (str1.compareTo(str2) > 0) {
            return HIGHER.toString();
        }
        return LOWER.toString();
    }

    public enum Result {
        EQUAL,
        LOWER,
        HIGHER
    }
}
