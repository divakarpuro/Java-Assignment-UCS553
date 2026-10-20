
import java.util.Objects;
import java.util.Optional;

class Result<T extends Number> {
    private T marks;
    private double totalMarks;

    Result(T marks, double totalMarks) {
        this.marks = Objects.requireNonNull(marks);
        this.totalMarks = totalMarks;

        if (totalMarks <= 0) {
            throw new IllegalArgumentException(
                "Total marks must be positive"
            );
        }
    }

    double percentage() {
        return marks.doubleValue() / totalMarks * 100;
    }

    boolean hasPassed(double threshold) {
        return percentage() >= threshold;
    }

    Optional<T> getMarks() {
        return Optional.ofNullable(marks);
    }
}

public class Q3 {
    public static void main(String[] args) {
        Result<Integer> r1 = new Result<>(75, 100);
        Result<Double> r2 = new Result<>(32.5, 50);

        r1.getMarks().ifPresent(m -> {
            System.out.println("Marks: " + m);
            System.out.println("Percentage: " + r1.percentage());
            System.out.println("Passed: " + r1.hasPassed(40));
        });

        r2.getMarks().ifPresent(m -> {
            System.out.println("\nMarks: " + m);
            System.out.println("Percentage: " + r2.percentage());
            System.out.println("Passed: " + r2.hasPassed(40));
        });
    }
}
