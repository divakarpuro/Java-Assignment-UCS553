
import java.util.Optional;
import java.util.Objects;

class Utility {
    public static <T> boolean isEqual(T a, T b) {
        return Objects.equals(a, b);
    }

    public static <T> T getDefault(
            Optional<T> value, T defaultValue) {
        return value.orElse(defaultValue);
    }

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    public static boolean isNull(Object obj) {
        return Objects.isNull(obj);
    }
}

public class Q5 {
    public static void main(String[] args) {
        System.out.println(Utility.isEqual("Java", "Java"));
        System.out.println(Utility.isEqual(10, 20));

        Optional<String> name = Optional.of("Divakar");
        Optional<String> empty = Optional.empty();

        System.out.println(Utility.getDefault(name, "Student"));
        System.out.println(Utility.getDefault(empty, "Student"));

        System.out.println(Utility.max(10, 25));
        System.out.println(Utility.max("Apple", "Banana"));

        String str = null;
        System.out.println(Utility.isNull(str));
        System.out.println(Utility.isNull("Hello"));
    }
}
